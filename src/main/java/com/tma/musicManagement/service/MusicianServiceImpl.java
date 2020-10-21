package com.tma.musicManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.tma.musicManagement.model.Musician;
import com.tma.musicManagement.repository.MusicianRepository;

@Service
@Primary
public class MusicianServiceImpl implements MusicianService {
	@Autowired
	private MusicianRepository musicianRepository;

	@Override
	public Iterable<Musician> getMusicians() {
		return musicianRepository.findAll();
	}

	@Override
	public String updateMusician(int musician_id, Musician musician) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createMusician(Musician musician) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteMusician(int musician_id) {
		// TODO Auto-generated method stub
		return null;
	}

}