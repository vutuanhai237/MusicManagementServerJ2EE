package com.tma.musicManagement.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tma.musicManagement.model.Music;
import com.tma.musicManagement.repository.MusicRepository;
import com.tma.musicManagement.utils.Constant;
import com.tma.musicManagement.validation.MusicValidation;

@Service
@Primary
public class MusicServiceImpl implements MusicService {
	@Autowired
	private MusicRepository musicRepository;

	@Override
	public Iterable<Music> getMusics() {
		return musicRepository.findAll();
	}

	@Override
	public String updateMusic(int music_id, Music music) {
		try {
			if (MusicValidation.check(music) == Constant.valid) {
				musicRepository.delete(music_id);
				musicRepository.save(music);
				return Constant.success;
			} else {
				return MusicValidation.check(music);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Constant.notSuccess;
	}

	@Override
	public ResponseEntity<Object> createMusic(Music music) {
//		try {
//			if (MusicValidation.check(music) == Constant.valid) {
//				musicRepository.save(music);
//				return Constant.success;
//			} else {
//				return MusicValidation.check(music);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			return Constant.notSuccess;
//		}
		Music savedMusic = musicRepository.save(music);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedMusic.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@Override
	public String deleteMusic(int music_id) {
		try {
			musicRepository.delete(music_id);
			return Constant.success;
		} catch (Exception e) {
			e.printStackTrace();
			return Constant.notSuccess;
		}

	}

}