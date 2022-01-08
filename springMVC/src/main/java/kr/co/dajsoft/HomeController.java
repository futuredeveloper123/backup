package kr.co.dajsoft;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.dajsoft.domain.EmailReport;
import kr.co.dajsoft.domain.Item;
import kr.co.dajsoft.domain.Member;
import kr.co.dajsoft.domain.User;
import kr.co.dajsoft.service.ItemService;
import kr.co.dajsoft.validator.MemberValidator;

@Controller //빈이 자동 생성 

public class HomeController {
	@Autowired
	private ItemService itemService;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	// "/"로 요청이 get방식으로 오면 호출되는 메서드 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	//문자열을 리턴하면 이 이름이 뷰이름이 되고 기본적으로 포워딩 됩니다 . 
	// "/" 요청이 오면 home 으로 포워딩합니다 .
	//home으로 포 워딩 하면 viewresolver 설 정에 의해서 web-int/views/home.jsp 파일로 포워딩 합니다 .
	public String home( Model model,
			HttpServletRequest request, HttpServletResponse response) {
		//데이터를 저장해서 전달 
		model.addAttribute("list",itemService.getList(request, response));
		return "home";
	}
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String hello() {
		return "hello";
	}//detail 요청의 가장 마지막 부분을 num에 대입 
	@RequestMapping(value="/detail/{num}",method=RequestMethod.GET)
	//위의 num 부분을 @PathVariable의 num에 대입 
	public void detail(@PathVariable int num) {
		System.out.println(num);
	}
	@RequestMapping(value="/param", method=RequestMethod.GET)
	public String param() {
		return "param";
	}
	/*
	@RequestMapping(value="/param", method=RequestMethod.POST)
	public String param( //@RequestPram을 이용하는 방법 
			@RequestParam("name") String name, 
			@RequestParam("age") String age, 
			@RequestParam("gender") String gender,
			@RequestParam("job") String job) {

		//httpservletrequest 객체를 이용한 파라미터 읽기 
		//없는 파라미터 이름을 이용하면 null
		//파라미터에 입력된 값이 없는 경우는 ""
		/*
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");
		String job = request.getParameter("job");
	 *
		System.out.println(name);
		System.out.println(age);
		System.out.println(gender);
		System.out.println(job);
		return "hello";
	}
	 */
	//command 객체를 이용하는 방법 
	@RequestMapping(value="/param", method=RequestMethod.POST)
	public String param(User user) { 
		System.out.println(user);
		return "hello";
	}
	//모든 요청 처리 결과에 전달하는 데이터를 생성해주는 메서드 
	@ModelAttribute("map")
	public Map<String, Object> allPass(){
		Map<String, Object> map = new HashMap<> ();
		map.put("parameter","date from client to server" );
		map.put("attribute","date from server to client" );
		return map;
	}
	@RequestMapping(value="/forward", method=RequestMethod.GET)
	public String forward(Model model) {
		//request.setAtrribute("이름",데이터)와 동일한 효과 
		model.addAttribute("전달할 데이터 이름 ", "forwarding할때 데이터 전달 " );
		return "result";	
	}
	@RequestMapping(value="/redirect", method=RequestMethod.GET)
	public String redirect(Model model,HttpSession session, RedirectAttributes rattr) {
		//redirect 의 경우는 이 문장은 아무런 의미가 없습ㄴ디ㅏ .
		//이렇게 작성하면 request에 저장되는데 redirect 면 request 는 다시 생성됩니다 .
		//이 경우는 session을 초기화하거나 data를 삭제하지 않는 한 계 속 유지 
		session.setAttribute("data ", "value " );
		//이 경우는 세션에 저장했다가 한 번 redirect 하 고 나면 자동 소멸됩니다 .
		rattr.addFlashAttribute("attr","value");
		//여기서 result는 controller에게 돌아오기 위한 ㅕ기이어야 합니다 . 
		//어딘가에 ㄱㄷ녀ㅣㅅ를 처리해주는 메서드가 있어야 합니다 .
		//데이터에 변화가 생기면 특별한 경우가 아니고는 redirect 
		return "redirect:result";
	}
	//상세보기 처리를 위한 메서드 
	@RequestMapping(value="/detail.html")
	public String getItem(@RequestParam("itemid")Integer itemid, Model model) {
		//서비스 메서드 호출 
		Item item = itemService.getItem(itemid);
		//출력할 데이터 저장 
		model.addAttribute("item",item);
		//출력할 뷰 이름 리턴 
		return "detail";	
	}
	/*
@RequestMapping(value="/detail.html/{itemid}")
public String getItem(@PathVariable Integer itemid, Model model) {
	//서비스 메서드 호출 
	Item item = itemService.getItem(itemid);
	//출력할 데이터 저장 
	model.addAttribute("item",item);
	//출력할  이름 리턴 
	return "detail";
}*//*
	//exception 요청이 발생했을 때 input.jsp를 출력하도록 해주는 메서드 
	@RequestMapping(value="/exception", method=RequestMethod.GET)
	public String exception() {
		return "input";
	}*/
	//input.jsp 의 form에서 submit을 눌렀을 대 처리하도록 해주는 메서드 
	//dividend와 divisor 파라미터의 값을 읽어서 나누셈을 해서 model에 저장하고 
	//result.jsp파일에 그 내용을 출력하도록 하기 
	@GetMapping("/cal")
	public String cal(@RequestParam("dividend")int dividend,
			@RequestParam("divisor") int divisor, Model model) {
		model.addAttribute("result", dividend/divisor);
		return "result";
	}
	//ArithmeticException 이 발생하면 출력할 페이지를 설정하는 메서드 
	@ExceptionHandler(ArithmeticException.class)
	public String handleException(Exception e, Model model) {
		model.addAttribute("content",e.getLocalizedMessage());
		return "error/exception";
	}
	//message 요청이 get방식으로 오면 처리하는 메서든 
	@GetMapping("/message")
	public String message(
			@ModelAttribute("member") Member memeber) {
		return "loginform";
	}
	@PostMapping("/message")
	public String message(
			@Valid @ModelAttribute("member") Member member , BindingResult result) {
		//유효성 검사 수행 
		new MemberValidator().validate(member,result);
		//검사 결과 에러가 있으면 
		if(result.hasErrors()) {
			return"loginform";
		}
		//검사 결과 에러가 없으면 시작 요청으로 리다이렉트 
		return "rediredc:/";
	}
	//모든 결과 페이지에 loginTypes 라는 이름의 메서드의 리턴값이 전달 
	@ModelAttribute("loginTypes")
	public List<String> loginType(){
		List<String> list = new ArrayList<>();
		list.add("일반회원");
		list.add("vip회원");
		list.add("관리자 ");
		return list;
	}
	//fileupload의 get요청을 처리하는 메서드 
	@GetMapping("fileupload") 
	public String fileupload() {
		return "fileupload"; 
	}
	@PostMapping("fileuploadrequest")//이거 이름 틀리면 안됌 .....*****
	//파일업로드를 request를 이용해서 처리 
	public String fileUpload(MultipartHttpServletRequest request) {
		String email = request.getParameter("email");
		MultipartFile report = request.getFile("report");
		System.out.println(email);
		System.out.println(report);

		return "redirect:/";
	}
	@PostMapping("fileuploadparam")//이거 이름 틀리면 안됌 .....*****
	//파일업로드를 request를 이용해서 처리 
	public String fileUpload(
			@RequestParam("email") String email,
			@RequestParam("report") MultipartFile report) {

		System.out.println(email);
		System.out.println(report);

		return "redirect:/";
	}
	@PostMapping("fileuploadcommand")//이거 이름 틀리면 안됌 .....*****
	//파일업로드를 request를 이용해서 처리 
	public String fileUpload(
			@ModelAttribute("emailReport") 
			EmailReport emailReport, HttpServletRequest request) {
		//파일을 업로드할 경로를 생성 
		//프로젝트 내의 webapp 내의 upload 디렉토리의 절대 경로 생성 
		String uploadPath = request.getServletContext().getRealPath("/upload");
		//업로드 된 파일의 원래 이름 
		String filename = emailReport.getReport().getOriginalFilename();
		//원본 그대로 파일명 만들기 
		//File filePath = new File(uploadPath +"/" +emailReport.getEmail()+filename);
		//랜덤한 32두자리 숫자를 추가 
		File filePath = new File(uploadPath +"/" + UUID.randomUUID());
		try {
			emailReport.getReport().transferTo(filePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/";
	}
}