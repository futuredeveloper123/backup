package kr.co.dajsoft.validator;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import kr.co.dajsoft.domain.Member;

public class MemberValidator implements Validator {
	// 유효성 검사 지원 여부를 설정하는 메서드 
	
	@Override
	public boolean supports(Class<?> clazz) {
		//member 클래스에 대한 유효성 검사 가능 여부를 리턴 
		return Member.class.isAssignableFrom(clazz);	
	}
	//유효성 검사를 수행하는 메서드 
	@Override
	//target은 유효성 검사를 수행하는 객체 
	//errors는 유효성 검사에서 유효성 실패했을 때의 메세지를 저장하는 객체 
	public void validate(Object target, Errors errors) {
	/*
			//유효성 검사를 수행할 객체 
			Member member = (Member)target;
			//검사 수행 
			if( member.getEmail()==null || member.getEmail().trim().isEmpty()) {
				errors.rejectValue("email","required");
			}
			if(member.getPw() == null || member.getPw().trim().isEmpty()) {
				errors.rejectValue("pw", "required");
		}
	}*/
	ValidationUtils.rejectIfEmpty(errors, "email","required");
	ValidationUtils.rejectIfEmpty(errors, "pw","required");
}
}