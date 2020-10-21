package com.tma.musicManagement.service;

import org.springframework.stereotype.Service;

import com.tma.musicManagement.model.Musician;

@Service
public interface MusicianService {
	public Iterable<Musician> getMusicians();

	public String updateMusician(int musician_id, Musician musician);

	public String createMusician(Musician musician);

	public String deleteMusician(int musician_id);
}
