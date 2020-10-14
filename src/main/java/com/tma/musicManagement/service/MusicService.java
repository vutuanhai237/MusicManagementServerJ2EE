package com.tma.musicManagement.service;

import org.springframework.stereotype.Service;

import com.tma.musicManagement.model.Music;

@Service
public interface MusicService {
	public Iterable<Music> getMusics();

	public String updateMusic(int music_id, Music music);

	public String createMusic(Music music);

	public String deleteMusic(int music_id);
}
