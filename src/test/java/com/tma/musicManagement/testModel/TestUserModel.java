package com.tma.musicManagement.testModel;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tma.musicManagement.dao.UserDAO;
import com.tma.musicManagement.model.User;
import com.tma.musicManagement.repository.UserRepository;
import com.tma.musicManagement.service.impl.UserServiceImpl;
import com.tma.musicManagement.utils.Constant;

@RunWith(SpringJUnit4ClassRunner.class)
public class TestUserModel {

	User user;
	UserServiceImpl userServiceImpl;
	UserRepository userRepository;

	@Before
	public void initTest() {
		userServiceImpl = new UserServiceImpl();
		UserDAO userDAO = new UserDAO();
		userDAO.setUserRepository(userRepository);
		userServiceImpl.setUserDAO(userDAO);
		user = new User();
		user.setId(1);
		user.setName("Hoài Linh");
		user.setUsername("abc");
		user.setPassword("123");
	}

	@Test
	public void test_UserModel_getId() {
		assertEquals(1, this.user.getId());
	}

	@Test
	public void test_UserModel_getName() {
		assertEquals("Hoài Linh", this.user.getName());
	}

	@Test
	public void test_UserModel_getUsername() {
		assertEquals("abc", this.user.getUsername());
	}

	@Test
	public void test_UserModel_getPassword() {
		assertEquals("123", this.user.getPassword());
	}

	@Test
	public void test_UserModel_toString() {
		assertEquals("Name: Hoài Linh", this.user.toString());
	}

	@Test
	public void test_MusicianModel_check_Valid() throws Exception {
		assertEquals(Constant.VALID, userServiceImpl.check(this.user));
	}

	@Test
	public void test_UserModel_check_NameNotValid1() throws Exception {
		this.user.setName("");
		assertEquals(Constant.NAME_NOT_VALID, userServiceImpl.check(this.user));
	}

	@Test
	public void test_UserModel_check_NameNotValid2() throws Exception {
		this.user.setName(
				"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		assertEquals(Constant.NAME_NOT_VALID, userServiceImpl.check(this.user));
	}

	@Test
	public void test_UserModel_check_null() throws Exception {
		try {
			this.user.setName(null);
			userServiceImpl.check(this.user);
		} catch (Exception e) {
			assertEquals(e.getMessage(), Constant.USER_NULL);

		}
	}

}
