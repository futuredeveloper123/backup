package kr.co.dajsoft.service;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.adamsoft.util.CryptoUtil;
import kr.co.dajsoft.dao.SpringUserMapper;
import kr.co.dajsoft.domain.SpringUser;
@Service
public class InterceptorUserServiceImple implements InterceptorUserService {
@Autowired
private SpringUserMapper springUserDao;

	@Override
	public SpringUser login(HttpServletRequest request, HttpServletResponse response) {
		SpringUser springUser = null;
		
		//파라미터 읽어오기 
		String email = request.getParameter("email");
		String pw = request.getParameter("userpw");
		
		//로그인 처리를 위해서 모든 user 찾아오기 
		List<SpringUser> list = springUserDao.login();
		
		//로그인 처리 
		for(SpringUser user : list) {
			
				try {
					if(CryptoUtil.decryptAES256(user.getEmail(), "itggangpae")
							.equals(email)&& BCrypt.checkpw(pw, user.getPw())) {
						user = new SpringUser();
						user.setEmail(email);
						user.setNickname(user.getNickname());
						user.setImage(user.getImage());
						break;
					}
				}
			} catch (InvalidKeyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
		return springUser;
		
	}


