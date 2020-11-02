package com.tma.musicManagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.tma.musicManagement.model.User;
import com.tma.musicManagement.repository.UserRepository;
import com.tma.musicManagement.service.UserService;

@Service
@Primary
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	public void setSingerRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User getUserById(int id) {
		return userRepository.findOne(id);
	}

	@Override
	public List<?> getMusicsByUId(int id) {
		return userRepository.getMusicsByUId(id);
	}

}