package com.tma.musicManagement.testModel;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tma.musicManagement.model.Playlist;

@RunWith(SpringJUnit4ClassRunner.class)
public class TestPlaylistModel {

	Playlist playlist;

	@Before
	public void initTest() {
		playlist = new Playlist();
		playlist.setMusicId(1);
		playlist.setUserId(1);
	}

	@Test
	public void test_PlaylistModel_getMusicId() {
		assertEquals(1, this.playlist.getMusicId());
	}

	@Test
	public void test_PlaylistModel_getUserId() {
		assertEquals(1, this.playlist.getUserId());
	}

}
