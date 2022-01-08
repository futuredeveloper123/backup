package kr.com.database;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.com.database.domain.Item;
import kr.com.database.service.ItemService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private ItemService itemService;
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest request, HttpServletResponse response) {
		
		
		model.addAttribute("list", itemService.getList(request, response));
		
		return "home";
	}
	
	
	// 상세보기 처리를 위한 메서드 - 파라미터를 이용하는 방식
	/*
	 * @RequestMapping(value="/detail.html") public String
	 * detail(@RequestParam("itemid") Integer itemid, Model model) { Item item =
	 * itemService.getItem(itemid); model.addAttribute("item",item); return
	 * "detail"; }
	 */
	
	@RequestMapping(value="/detail.html/{itemid}")
	public String getItem(@PathVariable Integer itemid, Model model) {
		Item item = itemService.getItem(itemid);
		model.addAttribute("item",item);
		return "detail";
	}
	
	// exception 요청이 발생했을 때 input.jsp 를 출력하도록 해주는 메서드
	/*
	 * @RequestMapping(value="/exception", method=RequestMethod.GET) public String
	 * exception() { return "input"; }
	 */
	
	// input.jsp 의 form 에서 submit 을 눌렀을 떄 처리하도록 해주는 메서드 
	// dividend 와 divisor 파라미터의 값을 읽어서 나누셈을 해서 Model 에 저장하고 result.jsp 파일에 그 내용을 출력하도록 하기
	@GetMapping("/cal")
	public String cal(@RequestParam("dividend") int dividend, @RequestParam("divisor") int divisor, Model model) {
		model.addAttribute("result", dividend/divisor);
		return "result";
	}
	
	// ArithmeticException 이 발생하면 출력할 페이지를 설정하는 메서드 
	@ExceptionHandler(ArithmeticException.class)
	public String handleException(Exception e, Model model) {
		model.addAttribute("content", e.getLocalizedMessage());
		return "error/exception";
	}
	
	// message 요청이 Get 방식으로 오면 처리하는 메서드
	@GetMapping("/message")
	public String message() {
		return "loginform";
	}
	
	
	
	
}
