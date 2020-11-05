package com.tma.musicManagerment.testController;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tma.musicManagement.controller.UserController;
import com.tma.musicManagement.model.User;
import com.tma.musicManagement.repository.UserRepository;
import com.tma.musicManagement.service.impl.UserServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class TestUserService {

	private UserController userController;
	private UserRepository userRepository;
	private User user1;

	@Before
	public void initTest() {
		User user1 = new User();
		user1.setName("A");
		user1.setUsername("abc");
		user1.setPassword("123");

	}

	@Test
	public void test_userController_getUsers() {

		UserRepository mockUserRepository = Mockito.mock(UserRepository.class);
		Mockito.when(mockUserRepository.findOne(1)).thenReturn(null);
		UserServiceImpl userService = new UserServiceImpl();
		userService.setUserRepository(mockUserRepository);
		userController = new UserController();
		userController.setUserService(userService);
		assertEquals(null, userController.getUserById(1));
	}

}
