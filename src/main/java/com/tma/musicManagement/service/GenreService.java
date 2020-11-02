package com.tma.musicManagement.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tma.musicManagement.model.Genre;

@Service
public interface GenreService {

	public Iterable<Genre> getGenres();

	public ResponseEntity<Object> updateGenre(int id, Genre genre);

	public ResponseEntity<Object> createGenre(Genre genre);

	public ResponseEntity<Object> deleteGenre(int id);
}
