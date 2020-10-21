package com.tma.musicManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tma.musicManagement.model.Singer;
import com.tma.musicManagement.service.SingerService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class SingerController {

	@Autowired
	private Singer singer;

	@Autowired
	private SingerService singerService;

	@GetMapping(path = "/singers")
	public @ResponseBody Iterable<Singer> getSingers() {
		System.out.print("GET SINGERS");
		return singerService.getSingers();
	}

}
