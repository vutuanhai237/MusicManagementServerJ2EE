package com.tma.musicManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tma.musicManagement.model.Musician;
import com.tma.musicManagement.service.MusicianService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class MusicianController {

	@Autowired
	private Musician musician;

	@Autowired
	private MusicianService musicianService;

	@GetMapping(path = "/musicians")
	public @ResponseBody Iterable<Musician> getMusician() {
		return musicianService.getMusicians();
	}

}
