package com.tma.musicManagement.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tma.musicManagement.model.Genre;
import com.tma.musicManagement.repository.GenreRepository;

@Repository
public class GenreDAO {
	@Autowired
	private GenreRepository genreRepository;

	public void setGenreRepository(GenreRepository genreRepository) {
		this.genreRepository = genreRepository;
	}

	public Iterable<Genre> getGenres() {
		return genreRepository.findAll();
	}

	public Genre getGenreById(int id) {
		return genreRepository.findOne(id);
	}

	public Genre createGenre(Genre genre) {
		return genreRepository.save(genre);
	}

	public void deleteById(int id) {
		genreRepository.delete(id);
	}
}
