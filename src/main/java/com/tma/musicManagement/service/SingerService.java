package com.tma.musicManagement.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tma.musicManagement.model.Singer;

@Service
public interface SingerService {
	public Iterable<Singer> getSingers();

	public ResponseEntity<Object> updateSinger(int id, Singer singer);

	public ResponseEntity<Object> createSinger(Singer singer);

	public ResponseEntity<Object> deleteSinger(int id);

	public Singer getSingerById(int id);
}
