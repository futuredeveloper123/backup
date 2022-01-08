package kr.co.dajsoft;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.dajsoft.domain.Item;
import kr.co.dajsoft.domain.ItemReport;
import kr.co.dajsoft.service.ItemService;
import kr.co.dajsoft.service.ViewService;
@Controller
public class ViewController {
	@Autowired
	private ViewService viewService;
	//fileview요청처리 
	@RequestMapping(value="fileview", method=RequestMethod.GET)
	public String fileview(HttpServletRequest request, HttpServletResponse response,Model model) {
		//서비스 메서드 호출 
		List<String> list = viewService.fileview(request, response);
		//데이터저장
		model.addAttribute("list",list);
		return "fileview";
	}
	//download 요청 처리 
	@RequestMapping("/download")
	public String download(@RequestParam("filename") String filename,Model model, HttpServletRequest request) {
		//view에게 전달할 데이터 생성 - 실제 파일 
		File downloadFile = new File(request.getServletContext().getRealPath("/img")+"/"+filename);	
		System.out.println(request.getServletContext().getRealPath("/img")+"/"+filename);
		//모델에 저장 
		model.addAttribute("downloadFile",downloadFile);				
		return "download";		
	}	
	@Autowired
	private ItemService itemService;
	@RequestMapping(value="/excel.xls")
	public String excel(Model model,HttpServletRequest request, HttpServletResponse response) { //파라미터가 없음 
	//출력할 데이터 생성 
		
		List<Item>list=itemService.getList(request, response);
		model.addAttribute("list",list);
		
		return "excel" ;
	
}
	@RequestMapping(value="/excelread")
	public String excelRead(Model model, HttpServletRequest request,HttpServletResponse response) {
		
		//서비스 메서드 호출 
		List<Map<String, Object>>list = viewService.excelRead(request, response);
		model.addAttribute("list",list);
		
		return "excelread";
	}
	@RequestMapping(value="/item.pdf")
	public String pdf(Model model,HttpServletRequest request,HttpServletResponse response) {
		//출력할 데이터를 가져옴 
		List<Item> list = itemService.getList(request,response); 
		//데이터 저장 
		model.addAttribute("list", list);
		//출력할 뷰 이름 결정 
		return "pdf";
	 }
	@RequestMapping(value="/item.json")
	public String json(Model model,HttpServletRequest request,HttpServletResponse response) {
		List<Item> list = itemService.getList(request, response); 
		model.addAttribute("list", list);
		return "json";
	}
	@RequestMapping(value="/item.xml")
	public String xml(Model model,HttpServletRequest request,HttpServletResponse response) {
		//데이터 저장 
		//xml 출력을 위한 어노테이션을 설정한 클래스의 인스턴스를 데이터로 지정 
		List<Item> list = itemService.getList(request, response); 
		model.addAttribute("list", new ItemReport(list));
		return "itemreport";
	}
	
	
}
