package com.tma.musicManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tma.musicManagement.model.Music;
import com.tma.musicManagement.repository.GenreRepository;

@Service
public class GenreServiceImpl implements MusicService {
	@Autowired
	private GenreRepository genreRepository;

	@Override
	public Iterable<Music> getMusics() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateMusic(int music_id, Music music) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createMusic(Music music) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteMusic(int music_id) {
		// TODO Auto-generated method stub
		return null;
	}

}