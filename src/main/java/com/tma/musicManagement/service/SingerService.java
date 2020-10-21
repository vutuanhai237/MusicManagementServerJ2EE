package com.tma.musicManagement.service;

import org.springframework.stereotype.Service;

import com.tma.musicManagement.model.Singer;

@Service
public interface SingerService {
	public Iterable<Singer> getSingers();

	public String updateSinger(int singer_id, Singer singer);

	public String createSinger(Singer singer);

	public String deleteSinger(int singer_id);
}
