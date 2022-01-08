package dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration//스프링의 팩토리클래스로 지정 
public class DaoFactory {
	//ItemDao클래스의 인스턴스를 생성해서 리턴해주는 메서
	@Bean//스프링빈을 생성해주는 메서드로 지정 
	public static ItemDao create() {
		return new ItemDao();
	}
}
