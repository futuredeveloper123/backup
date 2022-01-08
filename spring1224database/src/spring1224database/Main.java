package spring1224database;


import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.support.GenericXmlApplicationContext;


public class Main {
	public static void main(String[] args) {

	GenericXmlApplicationContext context = new GenericXmlApplicationContext ("applicationContext.xml");
	
	SqlSessionFactory sqlSessionFactory = context.getBean("sqlSessionFactory",SqlSessionFactory.class);
	
	System.out.println(sqlSessionFactory);
	
	context.close();
	/*
	DataSource ds = context.getBean("dataSource", DataSource.class);
	
	System.out.println(ds);
	
	
	try {
		Connection con = ds.getConnection();
		System.out.println(con);
		con.close();
		
	} catch (SQLException e) {
		
		System.out.println(e.getLocalizedMessage());
	
	}
	//contactcontroller 클래스의 인스턴스 가져오기 
	ContactController contactController = context.getBean("contactController", ContactController.class);
	
	//메서드 호출 
	contactController.getList();
	
	context.close();*/
	
}
}
