package main;

import org.springframework.context.support.GenericXmlApplicationContext;

import controller.UserController;



public class UserMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext context=
				new GenericXmlApplicationContext("applicationContext.xml");
		
		UserController userController =
				context.getBean("userController",UserController.class);
		
		userController.doGet();
		
		context.close();
		
	}

}
