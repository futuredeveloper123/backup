package kr.co.dajsoft;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.dajsoft.service.SpringUserService;
//데이터를 제공하기 위한  controller
@RestController
public class SpringUserRestController {
	@Autowired
	private SpringUserService springUserService;
	//회원가입 요청을 처리할 메서드 
	@PostMapping("/user/join")
	public Map<String,Object> join(MultipartHttpServletRequest rerquest, HttpServletResponse response){
		return springUserService.join(rerquest, response);
	}
	@GetMapping(value="user/emailcheck")
	public Map<String, Object> emailcheck(MultipartHttpServletRequest request, HttpServletResponse response) {
		return springUserService.emailCheck(request, response); 
		}
	@GetMapping(value="user/nicknamecheck")
	public Map<String, Object> nicknameCheck(MultipartHttpServletRequest request, HttpServletResponse response) {
		return springUserService.nicknameCheck(request, response); 
		}
	@PostMapping("/user/login")
	public Map<String, Object> login(MultipartHttpServletRequest request, HttpServletResponse response) {
		return springUserService.login(request, response); 
		}
	
}
