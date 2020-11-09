package com.tma.musicManagement.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.tma.musicManagement.model.Musician;
import com.tma.musicManagement.repository.MusicianRepository;

@Repository
public class MusicianDAO {
	@Autowired
	private MusicianRepository musicianRepository;

	public void setMusicianRepository(MusicianRepository musicianRepository) {
		this.musicianRepository = musicianRepository;
	}

	public Iterable<Musician> getMusicians() {
		return musicianRepository.findAll();
	}

	public Musician getMusicianById(int id) {
		return musicianRepository.findOne(id);
	}

	public ResponseEntity<Object> createMusician(Musician musician) {
		musicianRepository.save(musician);
		return ResponseEntity.noContent().build();
	}

	public void deleteMusicianById(int id) {
		musicianRepository.delete(id);
	}
}
