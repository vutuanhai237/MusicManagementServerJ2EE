package com.tma.musicManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tma.musicManagement.model.Genre;
import com.tma.musicManagement.service.GenreService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class GenreController {

	@Autowired
	private Genre genre;

	@Autowired
	private GenreService genreService;

	@GetMapping(path = "/genres")
	public @ResponseBody Iterable<Genre> readStudents() {
		return genreService.getGenres();
	}

}
