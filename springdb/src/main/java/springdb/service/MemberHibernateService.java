package springdb.service;

import java.util.List;

import springdb.domain.Member;

public interface MemberHibernateService {

	public void insertMember();
	public List<Member>getList();
	public Member getMember();
	public void updateMember();
	public void deleteMember();
}
