package com.tma.musicManagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tma.musicManagement.model.Genre;
import com.tma.musicManagement.repository.GenreRepository;
import com.tma.musicManagement.service.GenreService;

@Service
@Primary
public class GenreServiceImpl implements GenreService {
	@Autowired
	private GenreRepository genreRepository;

	public void setGenreRepository(GenreRepository genreRepository) {
		this.genreRepository = genreRepository;
	}

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

//	public URI getLocation(Genre savedGenre) {
//		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedGenre.getId())
//				.toUri();
//	}

	@Override
	public ResponseEntity<Object> createGenre(Genre genre) {
		Genre savedGenre = genreRepository.save(genre);
		// URI location = getLocation(savedGenre);
		return ResponseEntity.noContent().build();
	}

	@Override
	public ResponseEntity<Object> deleteGenre(int id) {
		Genre genreOptional = genreRepository.findOne(id);
		if (genreOptional == null) {
			return ResponseEntity.notFound().build();
		}

		genreRepository.delete(id);
		return ResponseEntity.noContent().build();

	}

}