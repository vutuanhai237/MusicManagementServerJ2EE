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

import com.tma.musicManagement.model.Musician;
import com.tma.musicManagement.service.MusicianService;

@CrossOrigin
@RestController
public class MusicianController {

	@Autowired
	private Musician musician;

	@Autowired
	private MusicianService musicianService;

	@GetMapping(path = "/musicians")
	public @ResponseBody Iterable<Musician> getMusicians() {
		return musicianService.getMusicians();
	}

	@PostMapping(path = "/musicians")
	public @ResponseBody ResponseEntity<Object> createMusician(@RequestBody Musician musician) {
		return musicianService.createMusician(musician);
	}

	@PutMapping(path = "/musicians")
	public @ResponseBody ResponseEntity<Object> updateMusician(@RequestParam int id, @RequestBody Musician musician) {
		return musicianService.updateMusician(id, musician);
	}

	@DeleteMapping(path = "/musicians")
	public @ResponseBody String deleteMusician(@RequestParam int id) {
		return musicianService.deleteMusician(id);
	}

}
