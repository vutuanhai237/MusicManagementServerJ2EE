package com.tma.musicManagement.service.impl;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tma.musicManagement.dao.SingerDAO;
import com.tma.musicManagement.model.Singer;
import com.tma.musicManagement.service.SingerService;
import com.tma.musicManagement.utils.Constant;

@Service
@Primary
public class SingerServiceImpl implements SingerService {

	@Autowired
	private SingerDAO singerDAO;
	private static Logger LOGGER = LogManager.getLogger(MusicianServiceImpl.class);

	public void setSingerDAO(SingerDAO singerDAO) {
		this.singerDAO = singerDAO;
	}

	@Override
	public Iterable<Singer> getSingers() {
		return singerDAO.getSingers();
	}

	@Override
	public ResponseEntity<Object> updateSinger(int id, Singer singer) {
		try {
			Singer singerOptional = this.getSingerById(id);
			if (singerOptional == null) {
				return ResponseEntity.notFound().build();
			}
			singer.setId(id);
			return this.createSinger(singer);
		} catch (Exception e) {
			String message = "Id singer or singer is not acceptable";
			LOGGER.error(message);
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(message);

		}
	}

	@Override
	public ResponseEntity<Object> createSinger(Singer singer) {
		try {
			String message = this.check(singer);
			if (message == Constant.VALID) {
				singerDAO.createSinger(singer);
				return ResponseEntity.noContent().build();
			} else {
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(message);
			}
		} catch (Exception e) {
			String message = "Singer is not acceptable";
			LOGGER.error(message);
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(message);

		}
	}

	@Override
	public ResponseEntity<Object> deleteSinger(int id) {
		try {
			Singer singerOptional = this.getSingerById(id);
			if (singerOptional == null) {
				return ResponseEntity.notFound().build();
			}
			singerDAO.deleteSingerById(id);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			String message = "Id singer is not acceptable";
			LOGGER.error(message);
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(message);

		}

	}

	public String check(Singer singer) throws Exception {
		try {
			if (singer.getName().length() < 1 || singer.getName().length() > 50) {
				return Constant.NAME_NOT_VALID;
			} else if (!singer.getSex().equals(Constant.SEXS.Female.toString())
					&& !singer.getSex().equals(Constant.SEXS.Male.toString())
					&& !singer.getSex().equals(Constant.SEXS.Other.toString())) {

				return Constant.SEX_NOT_VALID;
			}
			return Constant.VALID;
		} catch (Exception e) {
			throw new Exception(Constant.MUSICIAN_NULL);
		}

	}

	@Override
	public Singer getSingerById(int id) {
		try {
			return singerDAO.getSingerById(id);
		} catch (Exception e) {
			String message = "Id singer is not acceptable";
			LOGGER.error(message);
			return null;

		}

	}
}