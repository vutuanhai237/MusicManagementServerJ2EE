package com.tma.musicManagement.service.impl;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
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
	private static Logger LOGGER = LogManager.getLogger(PlaylistServiceImpl.class);

	public void setPlaylistDAO(PlaylistDAO playlistDAO) {
		this.playlistDAO = playlistDAO;
	}

	@Override
	public List<?> getPlaylistByUId(int id) {
		return (List<?>) playlistDAO.getMusicsByUId(id);
	}

	@Override
	public ResponseEntity<Object> createPlaylist(Playlist playlist) {
		try {
			playlistDAO.createPlaylist(playlist);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			String message = "Playlist is not acceptable";
			LOGGER.error(message);
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(message);

		}

	}

	@Override
	public Iterable<Playlist> getPlaylists() {
		try {
			return playlistDAO.getPlaylists();
		} catch (Exception e) {
			LOGGER.fatal("Database is error");
			return null;
		}
	}

	@Override
	public void deletePlaylistByID(int uid, int mid) {
		try {
			playlistDAO.deleteByTwoID(uid, mid);
		} catch (Exception e) {
			LOGGER.error("User id or music id is not acceptable");
		}

	}

}