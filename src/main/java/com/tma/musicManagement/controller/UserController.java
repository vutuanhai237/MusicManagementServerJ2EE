package com.tma.musicManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tma.musicManagement.model.User;
import com.tma.musicManagement.service.UserService;

@CrossOrigin
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	public void setPlaylistService(UserService playlistService) {
		this.userService = playlistService;
	}

	@GetMapping(path = "/user")
	public @ResponseBody User getUserById(@RequestParam int id) {
		return userService.getUserById(id);
	}

//	@PostMapping(path = "/playlist")
//	public @ResponseBody ResponseEntity<Object> createGenre(@RequestBody Genre genre) {
//		return playlistService.createGenre(genre);
//	}
//
//	@PutMapping(path = "/playlist")
//	public @ResponseBody ResponseEntity<Object> updateGenre(@RequestParam int id, @RequestBody Genre genre) {
//		return playlistService.updateGenre(id, genre);
//	}
//
//	@DeleteMapping(path = "/playlist")
//	public @ResponseBody ResponseEntity<Object> deleteGenre(@RequestParam int id) {
//		return playlistService.deleteGenre(id);
//	}

}
