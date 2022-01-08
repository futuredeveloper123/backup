package springdb.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springdb.service.ContactService;
//기본패키지 안에 있는 경우 bean을 자동으로 생성해주는 annotation
//Service는 사용자의 요구 사항을 처리하는 코드와 관련된 클래스라는 것을 알려주는것 
//component라고 작성해도됩니다. 
@Service
public class ContactServiceImpl implements ContactService {
@Autowired
private ContactDao contactDao;
	
}
