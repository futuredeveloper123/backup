package kr.co.dajsoft.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.adamsoft.util.CryptoUtil;
import kr.co.dajsoft.dao.SpringUserMapper;
import kr.co.dajsoft.domain.SpringUser;

@Service
public class SpringUserServiceImpl implements SpringUserService {
	@Autowired
	private SpringUserMapper springUserDao;

	@Override
	public Map<String, Object> join(MultipartHttpServletRequest request, HttpServletResponse response) {
		// 리턴할 결과를 저장한 인스턴스 
		Map<String,Object>map = new HashMap<>();
		//3개 데이터 주고싶어서 기본값 설정 (결과 초기화 )
		//회원가입 성공여부 
		map.put("result", false);
		//이메일 중복 검사 결과 
		map.put("emailcheck", false);
		//닉네임 중복 검사 결과 
		map.put("nicknamecheck", false);

		//파라미터 읽기 - controller에서 읽으면 하지 않아도 됨 
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String nickname = request.getParameter("nickname");

		//복호화가 가능한 암호화를 위해서 key를 셋업 
		String key = "itggangpae";


		//파일의 경우 mutlpartfile
		MultipartFile image = request.getFile("image");
		//파일이 여러개라면 getfiles (배열로 받아야함 !!!!!! )
		//List<MultipartFile> images=request.getFiles("image");

		//작업을 수행해야하면작업수행 

		//1. email 중복체크 수행 
		List<String> emailresult = springUserDao.emailCheck(key);
		//가져온 이메일 순회 
		boolean flag = false;
		for(String e : emailresult) {
			try {
				//복호화를 해서 비교 
				if(email.equals(CryptoUtil.decryptAES256(e, "itggangpae").equals(email)) ) {
					flag=true;
					break; 
				}
			}catch(Exception ex) {
				System.out.println(ex.getLocalizedMessage());
			}
		}

		if(flag==false) {
			map.put("emailcheck", true);
		}
		//2.닉네임 중복검사 수행 
		String nicknameresult = springUserDao.nicknameCheck(nickname);
		if(nicknameresult==null) {
			map.put("nicknamecheck", true);
		}

		//3. 파일 이름 생성 - 파일이름이중복되지 않도록 하기 위해서 UUID 쓸껐 

		String originalFileName = image.getOriginalFilename();
		//변경된 이름 
		String changeFileName = UUID.randomUUID().toString() + originalFileName;
		//회원가입 성공하면 파일 업되게 ! 
		//이메일과 닉네임 중복검사를 통과한 경우 회원가입 
		if(emailresult ==null && nicknameresult == null) {

			//레파지토리의 메서드를 호출해야 하면 필요한 파라미터를 생성 ! 
			SpringUser springUser = new SpringUser();
			try {
				//이메일을 복호화가 가능한 암호화를 이용해서 저장 
				springUser.setEmail(CryptoUtil.encryptAES256(email, key));
				//복호화가 불가능하고 비교만 가능한 방법으로 암호화를 해서  저장 
				springUser.setPw(BCrypt.hashpw(pw, BCrypt.gensalt()));
			}catch(Exception e) {
				System.out.println(e.getLocalizedMessage());
			}
			springUser.setNickname(nickname);
			springUser.setImage(changeFileName);

			//레포지토리 메서드를 호출 합니다 !!!
			int result = springUserDao.join(springUser);

			//성공하면 
			if(result > 0) {
				//파일 업로드 
				String uploadPath=
						request.getServletContext().getRealPath("/profile");
				String filePath = uploadPath + "/" + changeFileName;
				File f = new File(filePath);
				try {
					// 이미지가 있는 경우만 업로드 
					if(image.isEmpty()==false) {
						image.transferTo(f);
					}
					map.put("result",true);
				}catch(Exception e) {
					System.out.println(e.getLocalizedMessage());
				}
			}
		}
		//메서드 호출 결과 가지고 리턴할 데이터를 작성 
		return map;
	}
	@Override
	public Map<String, Object> emailCheck(HttpServletRequest request, HttpServletResponse response) {
		Map<String,Object> map = new HashMap<>();
		// 파라미터 읽기 
		String email = request.getParameter("email");
		List<String> result = springUserDao.emailCheck(email);
		//이메일이 존재하는 경우는 result에   false 
		//이메일이 없는 경우는 result 에 true
		if(result ==null) {
			map.put("result", true);
		}else {
			map.put("result", false);
		}
		return map;
	}
	@Override
	public Map<String, Object> nicknameCheck(HttpServletRequest request, HttpServletResponse response) {
		Map<String,Object> map = new HashMap<>();
		// 파라미터 읽기 
		String nickname = request.getParameter("nickname");
		String result = springUserDao.nicknameCheck(nickname);
		//이메일이 존재하는 경우는 result에   false 
		//이메일이 없는 경우는 result 에 true
		if(result ==null) {
			map.put("result", true);
		}else {
			map.put("result", false);
		}
		return map;
	}
	@Override
	public Map<String, Object> login(HttpServletRequest request, HttpServletResponse response) {
		Map<String,Object> map = new HashMap<>();
		//로그인 성공 여부를 먼저 저장 
		map.put("result", false);

		//파라미터 읽어오기 
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");

		//로그인 하기 위한 정보를 가져오기 
		List<SpringUser> list = springUserDao.login();

		//암호화할때 사용했던 키 
		String key = "itggangpae";
		try {
			for(SpringUser user : list) {
				//이메일과 비밀번호 비교 
				if(email.equals(CryptoUtil.decryptAES256(user.getEmail(), key))
						&& BCrypt.checkpw(pw, user.getPw()))
				{
					//로그인성공 
					map.put("result", true);
					//필요한 정보 저장 
					map.put("email", email);
					map.put("nickname", user.getNickname());
					map.put("image", user.getImage());
				}
			}
		}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		//세션에 저장 
		request.getSession().setAttribute("userinfo", map);
		return map;
	}	
}