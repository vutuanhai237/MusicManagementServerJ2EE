package com.tma.musicManagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tma.musicManagement.model.Musician;
import com.tma.musicManagement.repository.MusicianRepository;
import com.tma.musicManagement.service.MusicianService;

@Service
@Primary
public class MusicianServiceImpl implements MusicianService {
	@Autowired
	private MusicianRepository musicianRepository;

	public void setMusicianRepository(MusicianRepository musicianRepository) {
		this.musicianRepository = musicianRepository;
	}

	@Override
	public Iterable<Musician> getMusicians() {
		return musicianRepository.findAll();
	}

	@Override
	public ResponseEntity<Object> updateMusician(int id, Musician musician) {
		Musician genreOptional = musicianRepository.findOne(id);
		if (genreOptional == null) {
			System.out.print("1\n");
			return ResponseEntity.notFound().build();
		}
		musician.setId(id);
		musicianRepository.save(musician);
		return ResponseEntity.noContent().build();
	}

	@Override
	public ResponseEntity<Object> createMusician(Musician musician) {
		Musician savedMusician = musicianRepository.save(musician);
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//				.buildAndExpand(savedMusician.getId()).toUri();

//		return ResponseEntity.created(location).build();
		return ResponseEntity.noContent().build();
	}

	@Override
	public ResponseEntity<Object> deleteMusician(int id) {
		Musician musicianOptional = musicianRepository.findOne(id);
		if (musicianOptional == null) {
			return ResponseEntity.notFound().build();
		}
		musicianRepository.delete(id);
		return ResponseEntity.noContent().build();

	}

}