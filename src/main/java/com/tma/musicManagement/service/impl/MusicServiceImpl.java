package com.tma.musicManagement.service.impl;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tma.musicManagement.model.Music;
import com.tma.musicManagement.repository.MusicRepository;
import com.tma.musicManagement.service.MusicService;
import com.tma.musicManagement.utils.Constant;

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
	public ResponseEntity<Object> updateMusic(int id, Music music) {
		Music musicOptional = musicRepository.findOne(id);
		if (musicOptional == null) {
			System.out.print("1\n");
			return ResponseEntity.notFound().build();
		}
		music.setId(id);
		musicRepository.save(music);
		return ResponseEntity.noContent().build();
	}

	@Override
	public ResponseEntity<Object> createMusic(Music music) {
		Music savedMusic = musicRepository.save(music);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedMusic.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@Override
	public String deleteMusic(int music_id) {
		try {
			musicRepository.delete(music_id);
			return Constant.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return Constant.NOT_SUCCESS;
		}

	}

	@Override
	public List<?> getGenreQuantities() {
		return musicRepository.getGenreQuantities();
	}

	@Override
	public List<?> getMusicianQuantities() {
		return musicRepository.getMusicianQuantities();
	}

	@Override
	public List<?> getSingerQuantities() {
		return musicRepository.getSingerQuantities();
	}

}