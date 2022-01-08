package kr.co.dajsoft;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InterceptorController {
	@GetMapping("/interceptor/login")
	public String login() {
		return" interceptor/login";
	}
	@GetMapping("/interceptor/logout")
	public String logout() {
		return" redirect:/";
	}
	@GetMapping("/board/login")
	public String boardlist() {
		return" board/boardlist";
	}

	@GetMapping("/board/login")
	public String boardwrite() {
		return" board/boardwrite";
	}

}
