package com.tma.musicManagement.service.impl;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tma.musicManagement.model.Singer;
import com.tma.musicManagement.repository.SingerRepository;
import com.tma.musicManagement.service.SingerService;
import com.tma.musicManagement.utils.Constant;

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
	public ResponseEntity<Object> updateSinger(int id, Singer singer) {
		Singer genreOptional = singerRepository.findOne(id);
		if (genreOptional == null) {
			System.out.print("1\n");
			return ResponseEntity.notFound().build();
		}
		singer.setId(id);
		singerRepository.save(singer);
		return ResponseEntity.noContent().build();
	}

	@Override
	public ResponseEntity<Object> createSinger(Singer singer) {
		Singer savedSinger = singerRepository.save(singer);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedSinger.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

	@Override
	public String deleteSinger(int singer_id) {
		try {
			singerRepository.delete(singer_id);
			return Constant.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return Constant.NOT_SUCCESS;
		}

	}

}