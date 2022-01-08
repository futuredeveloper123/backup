package springdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import springdb.service.ContactService;

@Controller
public class ContactController {
	//컨트롤러는 조금 다름 //사용자의 요청과 매핑이 되는 부분이라서 
	//웹의 경우는 servlet으로 만들어 집니다.
	@Autowired
	private ContactService contactService;
	//골프장 부킹사이트를 만들때 5개 가지고 있으면 5개에서 부킹가능하도록 만들어주어야함 
	//골프장 별로도 관리 해야해서 각 지점 테이블에도 넣고 통합한곳에도 넣고 
	//그럼 dao를 두개 쓸 가능성이 높아서 //dao를 두개 쓰면 헷갈리니까//contactService이렇게 쓰는것 
	//이게 항상 기본 틀 
}
