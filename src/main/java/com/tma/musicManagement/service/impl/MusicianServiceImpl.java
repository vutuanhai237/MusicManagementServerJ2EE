package com.tma.musicManagement.service.impl;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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
	private static Logger LOGGER = LogManager.getLogger(MusicianServiceImpl.class);

	public void setMusicianDAO(MusicianDAO musicianDAO) {
		this.musicianDAO = musicianDAO;
	}

	@Override
	public Iterable<Musician> getMusicians() {
		return musicianDAO.getMusicians();
	}

	@Override
	public ResponseEntity<Object> updateMusician(int id, Musician musician) {
		try {
			Musician musicianOptional = musicianDAO.getMusicianById(id);
			if (musicianOptional == null) {
				return ResponseEntity.notFound().build();
			}
			musician.setId(id);
			return this.createMusician(musician);
		} catch (Exception e) {
			String message = "ID or musician is not acceptable";
			LOGGER.error(message);
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(message);

		}

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
			String message = "Musician is not acceptable";
			LOGGER.error(message);
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(message);

		}
	}

	@Override
	public ResponseEntity<Object> deleteMusician(int id) {
		try {
			Musician musicianOptional = musicianDAO.getMusicianById(id);
			if (musicianOptional == null) {
				return ResponseEntity.notFound().build();
			}
			musicianDAO.deleteMusicianById(id);
			return ResponseEntity.noContent().build();

		} catch (Exception e) {
			String message = "ID musician is not acceptable";
			LOGGER.error(message);
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(message);

		}

	}

	public String check(Musician musician) throws Exception {
		try {
			if (musician.getName().length() < 1 || musician.getName().length() > 50) {
				return Constant.NAME_NOT_VALID;
			} else if (!musician.getSex().equals(Constant.SEXS.Female.toString())
					&& !musician.getSex().equals(Constant.SEXS.Male.toString())
					&& !musician.getSex().equals(Constant.SEXS.Other.toString())) {
				return Constant.SEX_NOT_VALID;
			}
			return Constant.VALID;
		} catch (Exception e) {
			throw new Exception(Constant.MUSICIAN_NULL);
		}

	}
}