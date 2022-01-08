package kr.co.dajsoft.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface SpringUserService {
	//회원 가입을 위한 서비스 //파일 업로드가 잇을 떄 HTTPSERVLETREQUEST로 안되고MULTIPARTHTTPSERVLETREQUEST여야함 
	//결과로 회원가입 성공 여부 , 실패했을 때 이메일중복 체크 결과 여부 , 닉네임 중복 체크 결과 여부 이렇게 3가지를 줌 
	//다 성공하면 true, 실패하면 각각 false 이렇게 3개 주고싶을경울 return type을 뭘로 줄 건지 생각해 보기 
	//여러개면 배열 / 리스트 /디티오 / 맵 !!
	//서로간의 비교하면 배열 리스트 vs 비교안하면 맵 디티오 !!!
	//맵 ㅜㅜ 
	public Map<String, Object>join(
			MultipartHttpServletRequest request,
			HttpServletResponse response);
	//이메일 중복 검사를 위한 메서
	public Map<String, Object>emailCheck(
			HttpServletRequest request,
			HttpServletResponse response);
	//닉네 중복 검사를 위한 메서
	public Map<String, Object>nicknameCheck(
			HttpServletRequest request,
			HttpServletResponse response);
	//로그인 처리를 위한 메서드 
	public Map<String, Object>login(
			HttpServletRequest request,
			HttpServletResponse response);
	


}
