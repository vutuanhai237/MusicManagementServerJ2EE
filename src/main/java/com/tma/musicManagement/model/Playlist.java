package com.tma.musicManagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
//
//@Embeddable
//class PlaylistKey implements Serializable {
//
//	private static final long serialVersionUID = 1L;
//	private int music_id;
//	private int user_id;
//
//	public PlaylistKey() {
//
//	}
//
//	public int getMusicId() {
//		return music_id;
//	}
//
//	public void setMusicId(int music_id) {
//		this.music_id = music_id;
//	}
//
//	public int getUserId() {
//		return user_id;
//	}
//
//	public void setUserId(int user_id) {
//		this.user_id = user_id;
//	}
//}

@Entity
@Table(name = "Playlist")
@Component
public class Playlist {
	@Id
	private int id;
	@Column(name = "MUSIC_ID")
	private int music_id;
	@Column(name = "USER_ID")
	private int user_id;

	public Playlist() {
	}

	public int getMusicId() {
		return music_id;
	}

	public int getUserId() {
		return user_id;
	}

	public void setUserId(int user_id) {
		this.user_id = user_id;
	}

	public void setMusicId(int music_id) {
		this.music_id = music_id;
	}

//	public PlaylistKey getPlaylistKey(PlaylistKey id) {
//		return id;
//	}
//
//	public void setPlaylistKey(PlaylistKey id) {
//		this.id = id;
//	}
}
