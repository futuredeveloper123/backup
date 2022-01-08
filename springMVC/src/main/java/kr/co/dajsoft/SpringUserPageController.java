package kr.co.dajsoft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.dajsoft.service.SpringUserService;
//html출력을 위한 controller
@Controller
public class SpringUserPageController {
	@Autowired
	private SpringUserService springUserService;
	
	@GetMapping("/user/join")
	public String join() {
		return "user/join";
	}

	@GetMapping("/user/login")
	public String login() {
		return "user/login";
	}
	
}
