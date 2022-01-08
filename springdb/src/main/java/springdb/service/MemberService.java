package springdb.service;

import java.util.List;

import springdb.domain.Member;

public interface MemberService {

	public boolean insertMember();
	public List<Member> getList();
	public Member getMember();
	public boolean updateMember();
	public boolean deleteMember();
	//insert, update,delete 모양 같음 
}
