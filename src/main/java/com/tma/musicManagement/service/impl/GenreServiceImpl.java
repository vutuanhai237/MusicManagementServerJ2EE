package com.tma.musicManagement.service.impl;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tma.musicManagement.dao.GenreDAO;
import com.tma.musicManagement.model.Genre;
import com.tma.musicManagement.service.GenreService;
import com.tma.musicManagement.utils.Constant;

@Service
@Primary
public class GenreServiceImpl implements GenreService {
	@Autowired
	private GenreDAO genreDAO;
	private static Logger LOGGER = LogManager.getLogger(GenreServiceImpl.class);

	public void setGenreDAO(GenreDAO genreDAO) {
		this.genreDAO = genreDAO;
	}

	@Override
	public Iterable<Genre> getGenres() {
		return genreDAO.getGenres();
	}

	@Override
	public ResponseEntity<Object> updateGenre(int id, Genre genre) {
		try {
			Genre genreOptional = genreDAO.getGenreById(id);
			if (genreOptional == null) {
				return ResponseEntity.notFound().build();
			}
			genre.setId(id);
			return this.createGenre(genre);
		} catch (Exception e) {
			String message = "ID or genre is not acceptable";
			LOGGER.error(message);
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(message);
		}

	}

	@Override
	public ResponseEntity<Object> createGenre(Genre genre) {
		try {
			String message = this.check(genre);
			if (message == Constant.VALID) {
				genreDAO.createGenre(genre);
				return ResponseEntity.noContent().build();
			} else {
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(message);
			}
		} catch (Exception e) {
			String message = "Genre is not acceptable";
			LOGGER.error(message);
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(message);
		}
	}

	@Override
	public ResponseEntity<Object> deleteGenre(int id) {
		try {
			Genre genreOptional = genreDAO.getGenreById(id);
			if (genreOptional == null) {
				return ResponseEntity.notFound().build();
			}

			genreDAO.deleteById(id);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			String message = "ID genre is not acceptable";
			LOGGER.error(message);
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(message);

		}

	}

	public String check(Genre genre) throws Exception {
		try {
			if (genre.getName().length() < 50 && genre.getName().length() > 1) {
				return Constant.VALID;
			}
			return Constant.GENRE_NOT_VALID;
		} catch (Exception e) {
			throw new Exception(Constant.GENRE_NULL);
		}

	}
}