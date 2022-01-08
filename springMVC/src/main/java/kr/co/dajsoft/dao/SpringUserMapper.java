package kr.co.dajsoft.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import kr.co.dajsoft.domain.SpringUser;

@Repository
public interface SpringUserMapper {
//이메일 중복 확인을 위한 sql 
//이메일은 암호화를 했으므로 데이터베이스에서 직접 비교가 불가능해서 이메일을 리턴 
	@Select("select email from springUser where email = #{email}")
	public List<String> emailCheck(String email);
//닉네임 충복 처리를 위한 sql
	@Select("select nickname from springUser where nickname = #{nickname}")
	public String nicknameCheck(String nickname);
//회원가입을 위한 sql 
	@Insert("insert into springUser(email, pw, nickname, image) values(#{email},#{pw},#{nickname},#{image})")
	public int join(SpringUser springUser);
//로그인 처리를 위한 메서드 
	@Select("select email,pw,nickname,image from springuser")
	public List<SpringUser> login();
}
