package com.tma.musicManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tma.musicManagement.model.Playlist;
import com.tma.musicManagement.service.PlaylistService;

@CrossOrigin
@RestController
public class PlaylistController {

	@Autowired
	private PlaylistService playlistService;

	public void setPlaylistService(PlaylistService playlistService) {
		this.playlistService = playlistService;
	}

	@GetMapping(path = "/playlist")
	public @ResponseBody List<?> getPlaylistByUId(@RequestParam int id) {
		return playlistService.getPlaylistByUId(id);
	}

	@GetMapping(path = "/playlists")
	public @ResponseBody Iterable<Playlist> getPlaylists() {
		return playlistService.getPlaylists();
	}

	@PostMapping(path = "/playlist")
	public ResponseEntity<Object> getPlaylistByUId(@RequestBody Playlist playlist) {
		return playlistService.createPlaylist(playlist);
	}

	@DeleteMapping(path = "/playlist")
	public ResponseEntity<Object> deletePlaylistByTwoId(@RequestParam int uid, @RequestParam int mid) {
		return playlistService.deletePlaylistByID(uid, mid);
	}

	@DeleteMapping(path = "/playlists")
	public void deletePlaylist(@RequestParam int uid, @RequestParam int mid) {
		Playlist playlist = new Playlist();
		playlist.setMusicId(mid);
		playlist.setUserId(uid);
		playlistService.deletePlaylist(playlist);
	}
}
