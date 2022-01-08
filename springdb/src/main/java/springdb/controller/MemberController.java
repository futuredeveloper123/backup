package springdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import springdb.domain.Member;
import springdb.service.MemberHibernateService;
import springdb.service.MemberService;

@Controller
public class MemberController {
//@Autowired
	private MemberService memberService;
	
	@Autowired private MemberHibernateService memberHibernateService;
 	//데이터 삽입 메서드 
	public void insertMember() {
		/*
		boolean r = memberService.insertMember();
		if(r==true) {
			System.out.println("success");
		}else {
			System.out.println("fail");
		}
	}//테이블의 전체 데이터를 출력하는 메서드 */
		memberHibernateService.insertMember();
		System.out.println("success");
	}
	public void getList() {
		// TODO Auto-generated method stub
		List<Member> list = memberHibernateService.getList();
		for(Member member : list) {
			System.out.println(member);
	}
}
	//하나의 데이터를 조회하는 메서드 
	public void getMember() {
		Member member=memberHibernateService.getMember();
		if(member==null) {
			System.out.println("doesn't exist");
		}else {
			System.out.println(member);
		}
	}
	//데이터를 수정하는 메서드 
	public void updateMember() {
		memberHibernateService.updateMember();
		/*memberHibernateService.updateMember();
		if(result ==true) {
			System.out.println("success");
		}else {
			System.out.println("fail");
		}*/
	}
	public void deleteMember() {
		memberHibernateService.deleteMember();
		/*boolean result = memberService.deleteMember();
		if(result ==true) {
			System.out.println("success");
		}else {
			System.out.println("fail");
		}*/
}
} 