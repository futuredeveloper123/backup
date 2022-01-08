package kr.co.dajsoft.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dajsoft.domain.SpringUser;

public interface InterceptorUserService {
//로그인 처리 메서드 //일반적으로 로그인은 dto를 리턴함 
	public SpringUser login(
			HttpServletRequest request,
			HttpServletResponse response);
	
}
