package kr.com.database.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.com.database.domain.Item;

public interface ItemService {
//	public void getList(HttpServletRequest request, HttpServletResponse response);
	
	// 전체 보기를 위한 메서드
	public List<Item> getList(HttpServletRequest request, HttpServletResponse response);
	// 상세보기를 위한 메서드
	// 파라미터를 Controller 에서 읽도록 함
	// Service 에서 읽는 경우는 HttpServletRequest 가 매개변수로 들어가야 함 
	public  Item getItem(Integer itemid);
	
}
