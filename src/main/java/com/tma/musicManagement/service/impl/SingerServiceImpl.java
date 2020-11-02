package com.tma.musicManagement.service.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tma.musicManagement.model.Singer;
import com.tma.musicManagement.repository.SingerRepository;
import com.tma.musicManagement.service.SingerService;
import com.tma.musicManagement.utils.Constant;

@Service
@Primary
public class SingerServiceImpl implements SingerService {
	@Autowired
	private SingerRepository singerRepository;

	public void setSingerRepository(SingerRepository singerRepository) {
		this.singerRepository = singerRepository;
	}

	@Override
	public Iterable<Singer> getSingers() {
		return singerRepository.findAll();
	}

	@Override
	public ResponseEntity<Object> updateSinger(int id, Singer singer) {
		Singer singerOptional = singerRepository.findOne(id);
		if (singerOptional == null) {
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
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//				.buildAndExpand(savedSinger.getId()).toUri();
//
//		return ResponseEntity.created(location).build();
		return ResponseEntity.noContent().build();
	}

	@Override
	public ResponseEntity<Object> deleteSinger(int id) {
		Singer singerOptional = singerRepository.findOne(id);
		if (singerOptional == null) {
			return ResponseEntity.notFound().build();
		}
		singerRepository.delete(id);
		return ResponseEntity.noContent().build();
	}

	public static String check(Singer singer) throws Exception {
		try {
			if (singer.getName().length() < 1 || singer.getName().length() > 50) {
				return Constant.NAME_NOT_VALID;
			} else if (Arrays.stream(Constant.SEXS).anyMatch(singer.getSex()::equals) == false) {
				return Constant.SEX_NOT_VALID;
			}
			return Constant.VALID;
		} catch (Exception e) {
			return Constant.MUSICIAN_NULL;
		}

	}
}