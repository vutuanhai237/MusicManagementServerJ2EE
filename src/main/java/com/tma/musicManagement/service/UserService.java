package com.tma.musicManagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tma.musicManagement.model.User;

@Service
public interface UserService {

	public User getUserById(int id);

	public List<?> getMusicsByUId(int id);
}
