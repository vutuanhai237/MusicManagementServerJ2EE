package com.tma.musicManagement.service.impl;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.tma.musicManagement.dao.UserDAO;
import com.tma.musicManagement.model.User;
import com.tma.musicManagement.service.UserService;
import com.tma.musicManagement.utils.Constant;

@Service
@Primary
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	private static Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public User getUserById(int id) {
		try {

		} catch (Exception e) {
			String message = "Id user is not acceptable";
			LOGGER.error(message);
			return null;

		}
		return userDAO.getUserById(id);
	}

	public String check(User user) throws Exception {
		try {
			if (user.getName().length() < 1 || user.getName().length() > 50) {
				return Constant.NAME_NOT_VALID;
			}
			return Constant.VALID;
		} catch (Exception e) {
			throw new Exception(Constant.USER_NULL);
		}

	}
}