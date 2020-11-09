package com.tma.musicManagement.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.tma.musicManagement.model.Singer;
import com.tma.musicManagement.repository.SingerRepository;

@Repository
public class SingerDAO {
	@Autowired
	private SingerRepository singerRepository;

	public void setSingerRepository(SingerRepository singerRepository) {
		this.singerRepository = singerRepository;
	}

	public Iterable<Singer> getSingers() {
		return singerRepository.findAll();
	}

	public Singer getSingerById(int id) {
		return singerRepository.findOne(id);
	}

	public ResponseEntity<Object> createSinger(Singer singer) {
		singerRepository.save(singer);
		return ResponseEntity.noContent().build();
	}

	public void deleteSingerById(int id) {
		singerRepository.delete(id);
	}
}
