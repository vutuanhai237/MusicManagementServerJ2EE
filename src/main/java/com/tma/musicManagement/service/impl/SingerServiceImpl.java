package com.tma.musicManagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.tma.musicManagement.model.Singer;
import com.tma.musicManagement.repository.SingerRepository;
import com.tma.musicManagement.service.SingerService;

@Service
@Primary
public class SingerServiceImpl implements SingerService {
	@Autowired
	private SingerRepository singerRepository;

	@Override
	public Iterable<Singer> getSingers() {
		return singerRepository.findAll();
	}

	@Override
	public String updateSinger(int singer_id, Singer singer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createSinger(Singer singer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteSinger(int singer_id) {
		// TODO Auto-generated method stub
		return null;
	}

}