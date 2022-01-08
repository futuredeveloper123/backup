package serviceimpl;

import org.springframework.stereotype.Repository;

import domain.User;


@Repository

public class UserDao {

	public User getUser() {
		
		User user = new User();
		user.setId("da");
		user.setPw("1234");
		user.setNickname("jung");
		
		return user;
		
	}
}
