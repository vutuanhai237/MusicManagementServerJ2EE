package com.tma.musicManagement.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tma.musicManagement.model.Musician;

@Service
public interface MusicianService {
	public Iterable<Musician> getMusicians();

	public ResponseEntity<Object> updateMusician(int id, Musician musician);

	public ResponseEntity<Object> createMusician(Musician musician);

	public String deleteMusician(int id);
}
