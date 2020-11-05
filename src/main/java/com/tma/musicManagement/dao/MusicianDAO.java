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

	public ResponseEntity<Object> createMusician(Musician musician) {
		Musician savedMusician = musicianRepository.save(musician);
		return ResponseEntity.noContent().build();
	}

	public ResponseEntity<Object> deleteMusicianById(int id) {
		Musician musicianOptional = musicianRepository.findOne(id);
		if (musicianOptional == null) {
			return ResponseEntity.notFound().build();
		}
		musicianRepository.delete(id);
		return ResponseEntity.noContent().build();

	}
}
