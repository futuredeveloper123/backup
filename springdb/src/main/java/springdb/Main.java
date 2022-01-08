package springdb;

import java.sql.SQLException;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import springdb.controller.MemberController;

public class Main {
	@Test
	public void connectionTest() throws SQLException {

		GenericXmlApplicationContext context = new GenericXmlApplicationContext (
				"applicationContext.xml");
		
		
		MemberController memberController = context.getBean(
				"memberController", MemberController.class);
		//memberController.insertMember();
		//memberController.getList();
		//memberController.getMember();
		//memberController.updateMember();
		memberController.deleteMember();
		
		context.close();

	}

}
