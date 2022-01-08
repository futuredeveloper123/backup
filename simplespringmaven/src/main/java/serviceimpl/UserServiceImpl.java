package serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.User;
import service.UserService;

@Service
public class UserServiceImpl implements UserService {
@Autowired //setter가 자동으로 만들어지고 동일한 자료형의 bean이 있으면 자동 주입 

	private UserDao userDao;
	//serviceimpl에는 dao가 들어와야 된다 ! 
	/*
	public UserServiceImpl() {
		userDao = new UserDao();
	}
	//userDao 클래스의 setter 
	//setter 를 만들 때는 리턴타입은 void
	//메서드 이름은 set프로퍼티이름 - 프로퍼티이름의 첫글자는 대문자 
	//메서드의 매개변수는 만들고자 하는 프로퍼티와 동일한 자료형 1개 
	//내용은 인스턴스 변수에 매개변수를 대입하는 것 
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;	
	}*/
	
	public void getUser() {
		User user = userDao.getUser();
		System.out.println(user);

	}

}
