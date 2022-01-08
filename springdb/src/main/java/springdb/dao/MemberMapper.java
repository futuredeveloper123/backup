package springdb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import springdb.domain.Member;

@Repository
//인터페이스는 인스턴스를 만들수 없음 
//레포지토리는 인스턴스 만드는건데 ,,,왜 같이 사용되지 ? 
public interface MemberMapper {

	//전체 데이터 가져오기 
	@Select("select * from member")
	public List<Member> getList();
	
	//데이터1개 가져오기 
	@Select("select from member where MEMBER_ID=#{MEMBER_ID}")
	public Member getMember(String string);
	
	
	@Insert("insert into member values(#{MEMBER_ID},#{MEMBER_PW},#{MEMBER_NAME},"
			+ "#{MEMBER_EMAIL},#{MEMBER_PHONE},#{MEMBER_NICKNAME},#{MEMBER_GENDER},#{MEMBER_ADDRESS},#{MEMBER_IP},#{MEMBER_LOGINDATE},#{MEMBER_JOINDATE})")
	public int insertMember(Member member);
	
	@Update("update member set MEMBER_PW=#{MEMBER_PW} where MEMBER_ID=#{MEMBER_ID}")
	public int updateMember(Member member);
	
	@Delete("delete from member where MEMBER_ID=#{MEMBER_ID}")
	public int deleteMember(String string);

}
