package kr.co.dajsoft.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dajsoft.domain.Item;

public interface ItemService {
	//전체보기를 위한 메서드 
	public List<Item> getList(HttpServletRequest request, HttpServletResponse response);
	
	//파라미터를 어디서 읽을거냐 ,,, 서비스냐,,,,컨트롤러냐,,,,,,
	//상세보기를 위한 메서드 
	public Item getItem(Integer itemid);
	//이거는 파라미터를 controller에서 읽는 다는 것 
	//service에서 읽는 건 Integer대신에 HttpServletRequest 되는 것 
	
	
}

