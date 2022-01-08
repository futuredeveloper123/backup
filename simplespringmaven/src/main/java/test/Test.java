package test;

import org.junit.runner.RunWith;

import service.UserService;

@RunWith
@ContextConfiguration

public class Test {

	@Autowired
	private UserService userService;
	
	@Test
	public void method() {
		userService.getUser();
	}
}
