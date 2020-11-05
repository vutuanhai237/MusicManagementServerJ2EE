package com.tma.musicManagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.tma.musicManagement.model.User;
import com.tma.musicManagement.repository.UserRepository;
import com.tma.musicManagement.service.UserService;
import com.tma.musicManagement.utils.Constant;

@Service
@Primary
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User getUserById(int id) {
		return userRepository.findOne(id);
	}

	public static String check(User user) throws Exception {
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