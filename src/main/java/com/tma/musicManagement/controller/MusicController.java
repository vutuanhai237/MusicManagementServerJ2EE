package com.tma.musicManagement.controller;

import java.util.List;

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

import com.tma.musicManagement.model.Music;
import com.tma.musicManagement.model.Singer;
import com.tma.musicManagement.service.MusicService;

@CrossOrigin
@RestController
public class MusicController {

	@Autowired
	private MusicService musicService;

	public void setMusicService(MusicService musicService) {
		this.musicService = musicService;
	}

	@GetMapping(path = "/genre_quantities")
	public @ResponseBody List<?> getGenreQuantities() {
		return musicService.getGenreQuantities();
	}

	@GetMapping(path = "/musician_quantities")
	public @ResponseBody List<?> getMusicianQuantities() {
		return musicService.getMusicianQuantities();
	}

	@GetMapping(path = "/singer_quantities")
	public @ResponseBody List<?> getSingerQuantities() {
		return musicService.getSingerQuantities();
	}

	@PostMapping(path = "/musics_singer")
	public @ResponseBody Iterable<Music> getMusicsBySid(@RequestBody Singer singer) {
		return musicService.getMusicsBySinger(singer);
	}

	@GetMapping(path = "/musics")
	public @ResponseBody Iterable<Music> getMusics() {
		return musicService.getMusics();
	}

	@PostMapping(path = "/musics")
	public @ResponseBody ResponseEntity<Object> createMusic(@RequestBody Music music) {
		return musicService.createMusic(music);
	}

	@PutMapping(path = "/musics")
	public @ResponseBody ResponseEntity<Object> updateMusic(@RequestParam int id, @RequestBody Music music) {
		return musicService.updateMusic(id, music);
	}

	@DeleteMapping(path = "/musics")
	public @ResponseBody ResponseEntity<Object> deleteMusic(@RequestParam int id) {
		return musicService.deleteMusic(id);
	}
}
