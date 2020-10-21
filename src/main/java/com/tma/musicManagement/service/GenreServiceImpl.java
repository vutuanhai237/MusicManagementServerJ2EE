package com.tma.musicManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tma.musicManagement.model.Genre;
import com.tma.musicManagement.repository.GenreRepository;

@Service
public class GenreServiceImpl implements GenreService {
	@Autowired
	private GenreRepository genreRepository;

	@Override
	public Iterable<Genre> getGenres() {
		return genreRepository.findAll();
	}

	@Override
	public String updateGenre(Genre genre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createGenre(Genre genre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteGenre(int genre_id) {
		// TODO Auto-generated method stub
		return null;
	}

}