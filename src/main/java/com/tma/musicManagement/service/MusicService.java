package com.tma.musicManagement.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tma.musicManagement.model.Music;

@Service
public interface MusicService {
	public Iterable<Music> getMusics();

	public String updateMusic(int music_id, Music music);

	public ResponseEntity<Object> createMusic(Music music);

	public String deleteMusic(int music_id);
}
