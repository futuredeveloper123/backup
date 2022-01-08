package springdb.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springdb.domain.Member;

//@Repository
public class MeberDao {
	
@Autowired 
// xml을 이용하는 mybatis 사용 객체 
	private SqlSession sqlSession;

	//데이터 삽입 메서드 
	public int insertMember(Member member) {
		//member namespace의 insertmemeber이라는 id를 가진sql을 실행하는데 
		//파라미터로 member을 대입 
		return sqlSession.insert("member.insertmember",member);
	}
//	public Integer maxCode() {
//		return sqlSession.selectOne("memeber.maxcode");
//	}
	public List<Member> getList() {
		return sqlSession.selectList("member.getlist");
	}
	public Member getMember(String MEMBER_ID) {
		//조회되는 데이터가 없거나 1개인 경우 사용 !!!!!
		//데이터가 없으면 null을 리턴하고 1개인 경우는 resultType 1개 리턴! 
		//2개 이상이면 예외 발생 
		return sqlSession.selectOne("member.getmember",MEMBER_ID);
	}
	public int updateMember(Member member) {
		return sqlSession.update("member.updatemember",member);
	}
	public int deleteMember(String id) {
		return sqlSession.delete("member.deletemember",id);
}
}
