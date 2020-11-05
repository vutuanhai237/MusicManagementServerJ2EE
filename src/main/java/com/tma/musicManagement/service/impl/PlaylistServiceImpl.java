package com.tma.musicManagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tma.musicManagement.dao.PlaylistDAO;
import com.tma.musicManagement.model.Playlist;
import com.tma.musicManagement.service.PlaylistService;

@Service
@Primary
public class PlaylistServiceImpl implements PlaylistService {
	@Autowired
	private PlaylistDAO playlistDAO;

	public void setPlaylistDAO(PlaylistDAO playlistDAO) {
		this.playlistDAO = playlistDAO;
	}

	@Override
	public List<?> getPlaylistByUId(int id) {
		return (List<?>) playlistDAO.getMusicsByUId(id);
	}

	@Override
	public ResponseEntity<Object> createPlaylist(Playlist playlist) {
		playlistDAO.createPlaylist(playlist);
		return ResponseEntity.noContent().build();
	}

	@Override
	public Iterable<Playlist> getPlaylists() {
		return playlistDAO.getPlaylists();
	}

	@Override
	public void deletePlaylistByID(int uid, int mid) {
		playlistDAO.deleteByTwoID(uid, mid);
	}

	@Override
	public void deletePlaylist(Playlist playlist) {
		playlistDAO.deletePlaylist(playlist);
	}

}