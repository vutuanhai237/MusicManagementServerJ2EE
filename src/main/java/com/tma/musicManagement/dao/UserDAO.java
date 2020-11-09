package com.tma.musicManagement.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tma.musicManagement.model.User;
import com.tma.musicManagement.repository.UserRepository;

@Repository
public class UserDAO {
	@Autowired
	private UserRepository userRepository;

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User getUserById(int id) {
		return userRepository.findOne(id);
	}

}
