package kr.co.dajsoft.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ViewService {

	//파일의 목록을 가져오는 서비스 메서드 
	public List<String> fileview(HttpServletRequest request,HttpServletResponse response);
	
	public List<Map<String, Object>> excelRead(HttpServletRequest request, HttpServletResponse response);
	
}
