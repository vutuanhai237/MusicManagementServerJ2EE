package com.tma.musicManagement.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tma.musicManagement.model.Playlist;

@Service
public interface PlaylistService {

	public List<?> getPlaylistByUId(int id);

	public ResponseEntity<Object> createPlaylist(Playlist playlist);

	public Iterable<Playlist> getPlaylists();

	public void deletePlaylist(Playlist playlist);

	public ResponseEntity<Object> deletePlaylistByID(int uid, int mid);
}
