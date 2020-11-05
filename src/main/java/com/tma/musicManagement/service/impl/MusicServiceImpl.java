package com.tma.musicManagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tma.musicManagement.dao.MusicDAO;
import com.tma.musicManagement.model.Music;
import com.tma.musicManagement.model.Singer;
import com.tma.musicManagement.service.MusicService;
import com.tma.musicManagement.utils.Constant;

@Service
@Primary
public class MusicServiceImpl implements MusicService {
	@Autowired
	private GenreServiceImpl genreServiceImpl;
	@Autowired
	private MusicianServiceImpl musicianServiceImpl;
	@Autowired
	private MusicDAO musicDAO;

	public void setMusicDAO(MusicDAO musicDAO) {
		this.musicDAO = musicDAO;
	}

	@Override
	public Iterable<Music> getMusics() {
		return musicDAO.getMusics();

	}

	@Override
	public ResponseEntity<Object> updateMusic(int id, Music music) {
		Music musicOptional = musicDAO.getMusicById(id);
		if (musicOptional == null) {

			return ResponseEntity.notFound().build();
		}
		music.setId(id);
		this.createMusic(music);
		return ResponseEntity.noContent().build();
	}

	@Override
	public ResponseEntity<Object> createMusic(Music music) {
		try {
			String message = this.check(music);
			if (message == Constant.VALID) {
				musicDAO.createMusic(music);
				return ResponseEntity.noContent().build();
			} else {
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(message);
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@Override
	public ResponseEntity<Object> deleteMusic(int id) {
		Music musicOptional = musicDAO.getMusicById(id);
		if (musicOptional == null) {
			return ResponseEntity.notFound().build();
		}
		musicDAO.deleteMusicById(id);
		return ResponseEntity.noContent().build();
	}

	@Override
	public Iterable<Music> getMusicsBySinger(Singer singer) {
		return musicDAO.getMusicsBySinger(singer);
	}

	@Override
	public List<?> getGenreQuantities() {
		return musicDAO.getGenreQuantities();
	}

	@Override
	public List<?> getMusicianQuantities() {
		return musicDAO.getMusicianQuantities();
	}

	@Override
	public List<?> getSingerQuantities() {
		return musicDAO.getSingerQuantities();
	}

	public String check(Music music) throws Exception {
		try {
			String result = this.genreServiceImpl.check(music.getGenre());
			if (result != Constant.VALID) {
				return result;
			}
		} catch (Exception e) {
			throw new Exception(Constant.GENRE_NULL);
		}
		try {
			String result = this.musicianServiceImpl.check(music.getMusician());
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