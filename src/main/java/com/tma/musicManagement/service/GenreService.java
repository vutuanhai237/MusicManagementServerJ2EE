package com.tma.musicManagement.service;

import org.springframework.stereotype.Service;

import com.tma.musicManagement.model.Genre;

@Service
public interface GenreService {
	public Iterable<Genre> getGenres();

	public String updateGenre(Genre genre);

	public String createGenre(Genre genre);

	public String deleteGenre(int genre_id);

}
