package com.tma.musicManagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tma.musicManagement.model.Playlist;
import com.tma.musicManagement.repository.PlaylistRepository;

@Repository
public class PlaylistDAO {
	@Autowired
	private PlaylistRepository playlistRepository;

	public void setPlaylistRepository(PlaylistRepository playlistRepository) {
		this.playlistRepository = playlistRepository;
	}

	public List<?> getMusicsByUId(int id) {
		return playlistRepository.getMusicsByUId(id);
	}

	public Playlist createPlaylist(Playlist playlist) {
		return playlistRepository.save(playlist);
	}

	public Iterable<Playlist> getPlaylists() {
		return playlistRepository.findAll();
	}

	public void deletePlaylist(Playlist playlist) {
		playlistRepository.delete(playlist);
	}

	public void deletePlaylistByID(int uid, int mid) {

	}

	public void deleteByTwoID(int uid, int mid) {
		playlistRepository.deleteByTwoID(uid, mid);
	}

}
