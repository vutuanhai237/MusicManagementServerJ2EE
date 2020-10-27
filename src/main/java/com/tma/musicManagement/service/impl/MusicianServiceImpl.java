package com.tma.musicManagement.service.impl;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tma.musicManagement.model.Musician;
import com.tma.musicManagement.repository.MusicianRepository;
import com.tma.musicManagement.service.MusicianService;
import com.tma.musicManagement.utils.Constant;

@Service
@Primary
public class MusicianServiceImpl implements MusicianService {
	@Autowired
	private MusicianRepository musicianRepository;

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
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedMusician.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

	@Override
	public String deleteMusician(int musician_id) {
		try {
			musicianRepository.delete(musician_id);
			return Constant.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return Constant.NOT_SUCCESS;
		}

	}

}