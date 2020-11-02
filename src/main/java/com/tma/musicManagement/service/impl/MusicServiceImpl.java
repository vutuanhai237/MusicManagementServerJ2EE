package com.tma.musicManagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tma.musicManagement.model.Music;
import com.tma.musicManagement.repository.MusicRepository;
import com.tma.musicManagement.service.MusicService;
import com.tma.musicManagement.utils.Constant;

@Service
@Primary
public class MusicServiceImpl implements MusicService {
	@Autowired
	private MusicRepository musicRepository;

	public void setMusicRepository(MusicRepository musicRepository) {
		this.musicRepository = musicRepository;
	}

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
		musicRepository.save(music);
		return ResponseEntity.noContent().build();
	}

	@Override
	public ResponseEntity<Object> createMusic(Music music) {
		Music savedMusic = musicRepository.save(music);
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedMusic.getId())
//				.toUri();
//
//		return ResponseEntity.created(location).build();
		return ResponseEntity.noContent().build();
	}

	@Override
	public ResponseEntity<Object> deleteMusic(int id) {
		Music musicOptional = musicRepository.findOne(id);
		if (musicOptional == null) {
			System.out.print("1\n");
			return ResponseEntity.notFound().build();
		}
		musicRepository.delete(id);
		return ResponseEntity.noContent().build();
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

	public static String check(Music music) throws Exception {
		try {
			String result = GenreServiceImpl.check(music.getGenre());
			if (result != Constant.VALID) {
				return result;
			}
		} catch (Exception e) {
			throw new Exception(Constant.GENRE_NULL);
		}

		try {
			String result = MusicianServiceImpl.check(music.getMusician());
			if (result != Constant.VALID) {
				return result;
			}
		} catch (Exception e) {
			throw new Exception(Constant.MUSICIAN_NULL);
		}
		try {
			return SingerServiceImpl.check(music.getSinger());
		} catch (Exception e) {
			throw new Exception(Constant.SINGER_NULL);
		}
	}

}