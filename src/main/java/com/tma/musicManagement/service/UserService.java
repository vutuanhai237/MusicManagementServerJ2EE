package com.tma.musicManagement.service;

import org.springframework.stereotype.Service;

import com.tma.musicManagement.model.User;

@Service
public interface UserService {

	public User getUserById(int id);

}
