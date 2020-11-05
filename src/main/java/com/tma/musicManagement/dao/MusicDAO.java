package com.tma.musicManagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tma.musicManagement.model.Music;
import com.tma.musicManagement.model.Singer;
import com.tma.musicManagement.repository.MusicRepository;

@Repository
public class MusicDAO {
	@Autowired
	private MusicRepository musicRepository;

	public void setMusicRepository(MusicRepository mockMusicRepository) {
		this.musicRepository = musicRepository;
	}

	public Iterable<Music> getMusics() {
		return musicRepository.findAll();
	}

	public List<?> getGenreQuantities() {
		return musicRepository.getGenreQuantities();
	}

	public List<?> getMusicianQuantities() {
		return musicRepository.getMusicianQuantities();
	}

	public List<?> getSingerQuantities() {
		return musicRepository.getSingerQuantities();
	}

	public Music createMusic(Music music) {
		return musicRepository.save(music);
	}

	public void deleteMusicById(int id) {
		musicRepository.delete(id);
	}

	public Iterable<Music> getMusicsBySinger(Singer singer) {
		return musicRepository.getMusicsBySinger(singer);
	}

	public Music getMusicById(int id) {
		return musicRepository.findOne(id);
	}

}
