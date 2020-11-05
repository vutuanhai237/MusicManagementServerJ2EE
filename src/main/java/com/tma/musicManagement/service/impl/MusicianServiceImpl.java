package com.tma.musicManagement.service.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tma.musicManagement.dao.MusicianDAO;
import com.tma.musicManagement.model.Musician;
import com.tma.musicManagement.service.MusicianService;
import com.tma.musicManagement.utils.Constant;

@Service
@Primary
public class MusicianServiceImpl implements MusicianService {
	@Autowired
	private MusicianDAO musicianDAO;

	public void setMusicianDAO(MusicianDAO musicianDAO) {
		this.musicianDAO = musicianDAO;
	}

	@Override
	public Iterable<Musician> getMusicians() {
		return musicianDAO.getMusicians();
	}

	@Override
	public ResponseEntity<Object> updateMusician(int id, Musician musician) {
		Musician musicianOptional = musicianDAO.getMusicianById(id);
		if (musicianOptional == null) {
			return ResponseEntity.notFound().build();
		}
		musician.setId(id);
		return this.createMusician(musician);
	}

	@Override
	public ResponseEntity<Object> createMusician(Musician musician) {
		try {
			String message = this.check(musician);
			if (message == Constant.VALID) {
				musicianDAO.createMusician(musician);
				return ResponseEntity.noContent().build();
			} else {
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(message);
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@Override
	public ResponseEntity<Object> deleteMusician(int id) {
		return musicianDAO.deleteMusicianById(id);
	}

	public String check(Musician musician) throws Exception {
		try {
			if (musician.getName().length() < 1 || musician.getName().length() > 50) {
				return Constant.NAME_NOT_VALID;
			} else if (Arrays.stream(Constant.SEXS).anyMatch(musician.getSex()::equals) == false) {
				return Constant.SEX_NOT_VALID;
			}
			return Constant.VALID;
		} catch (Exception e) {
			throw new Exception(Constant.MUSICIAN_NULL);
		}

	}
}