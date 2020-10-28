package com.tma.musicManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tma.musicManagement.model.Genre;
import com.tma.musicManagement.service.GenreService;

@CrossOrigin
@RestController
public class GenreController {

	@Autowired
	private GenreService genreService;

	public void setGenreService(GenreService genreService) {
		this.genreService = genreService;
	}

	@GetMapping(path = "/genres")
	public @ResponseBody Iterable<Genre> getGenres() {
		return genreService.getGenres();
	}

	@PostMapping(path = "/genres")
	public @ResponseBody ResponseEntity<Object> createGenre(@RequestBody Genre genre) {
		return genreService.createGenre(genre);
	}

	@PutMapping(path = "/genres")
	public @ResponseBody ResponseEntity<Object> updateGenre(@RequestParam int id, @RequestBody Genre genre) {
		return genreService.updateGenre(id, genre);
	}

	@DeleteMapping(path = "/genres")
	public @ResponseBody ResponseEntity<Object> deleteGenre(@RequestParam int id) {
		return genreService.deleteGenre(id);
	}

}
