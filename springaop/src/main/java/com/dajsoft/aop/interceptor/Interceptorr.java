package com.dajsoft.aop.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
@Component 
//빈을 자동으로 생성해주는 패키지 
public class Interceptorr extends HandlerInterceptorAdapter {
	//오버라이딩 된 메서드라는 것을 명시하는 어노테이션으로 상위 클래스에 존재하지 않으면 에러 
	@Override 
	//controller에게 요청을 하기 전에 호출되는 메서드 
	//true를 리턴하면 컨트롤러의 요청 처리 메서드를 호출하고 
	//false를 리턴하면 컨트롤러의 요청 처리 메서드를 호출하지 않습니다 
	public boolean preHandle(
			HttpServletRequest request, HttpServletResponse response, Object handler) {
		System.out.println("controller의 요청 처리 메서드 호출하기 전 ");
		return  true;
	}
	@Override
	//컨트롤러가 요청을 정상적으로 처리한후 호출되는 메서드 
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
		System.out.println("controller의 요청 처리 메서드가 정상적으로 일을 처리함  ");
	}
	@Override
	//컨트롤러의요청 처리 메서드가 수행되고 나면 무조건 호출 
	public void afterCompletion(
			HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) {
		System.out.println("controller의 요청 처리 메서드 호출되고 난 후 무조건 호출 ");
	}
}
