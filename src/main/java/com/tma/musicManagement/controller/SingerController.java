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

import com.tma.musicManagement.model.Singer;
import com.tma.musicManagement.service.SingerService;

@CrossOrigin
@RestController
public class SingerController {

	@Autowired
	private SingerService singerService;

	public void setSingerService(SingerService singerService) {
		this.singerService = singerService;
	}

	@GetMapping(path = "/singers")
	public @ResponseBody Iterable<Singer> getSingers() {
		return singerService.getSingers();
	}

	@PostMapping(path = "/singers")
	public @ResponseBody ResponseEntity<Object> createSinger(@RequestBody Singer singer) {
		return singerService.createSinger(singer);
	}

	@PutMapping(path = "/singers")
	public @ResponseBody ResponseEntity<Object> updateSinger(@RequestParam int id, @RequestBody Singer singer) {
		return singerService.updateSinger(id, singer);
	}

	@DeleteMapping(path = "/singers")
	public @ResponseBody ResponseEntity<Object> deleteSinger(@RequestParam int id) {
		return singerService.deleteSinger(id);
	}

}
