package com.tma.musicManagement.service.impl;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tma.musicManagement.model.Genre;
import com.tma.musicManagement.repository.GenreRepository;
import com.tma.musicManagement.service.GenreService;
import com.tma.musicManagement.utils.Constant;

@Service
@Primary
public class GenreServiceImpl implements GenreService {
	@Autowired
	private GenreRepository genreRepository;

	@Override
	public Iterable<Genre> getGenres() {
		return genreRepository.findAll();
	}

	@Override
	public ResponseEntity<Object> updateGenre(int id, Genre genre) {
		Genre genreOptional = genreRepository.findOne(id);
		if (genreOptional == null) {
			System.out.print("1\n");
			return ResponseEntity.notFound().build();
		}
		genre.setId(id);
		genreRepository.save(genre);
		return ResponseEntity.noContent().build();
	}

	@Override
	public ResponseEntity<Object> createGenre(Genre genre) {
		Genre savedMusic = genreRepository.save(genre);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedMusic.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@Override
	public String deleteGenre(int genre_id) {
		try {
			genreRepository.delete(genre_id);
			return Constant.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return Constant.NOT_SUCCESS;
		}

	}

}