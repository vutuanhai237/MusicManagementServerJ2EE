package com.tma.musicManagement.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tma.musicManagement.model.Music;

@Service
public interface MusicService {
	public Iterable<Music> getMusics();

	public List<?> getGenreQuantities();

	public List<?> getMusicianQuantities();

	public List<?> getSingerQuantities();

	public ResponseEntity<Object> updateMusic(int id, Music music);

	public ResponseEntity<Object> createMusic(Music music);

	public String deleteMusic(int id);
}
