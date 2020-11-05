package com.tma.musicManagerment.testController;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tma.musicManagement.controller.PlaylistController;
import com.tma.musicManagement.model.Playlist;
import com.tma.musicManagement.repository.PlaylistRepository;
import com.tma.musicManagement.service.impl.PlaylistServiceImpl;
import com.tma.musicManagement.utils.Helper;

@RunWith(SpringJUnit4ClassRunner.class)
public class TestPlaylistService {

	private PlaylistController playlistController;
	private PlaylistRepository playlistRepository;
	private Playlist playlist1;
	private Playlist playlist2;

	@Before
	public void initTest() {
		playlist1 = new Playlist();
		playlist1.setMusicId(1);
		playlist1.setUserId(1);
		playlist2 = new Playlist();
		playlist2.setMusicId(2);
		playlist2.setUserId(2);
	}

	@Test
	public void test_playlistController_getPlaylists() {

		PlaylistRepository mockPlaylistRepository = Mockito.mock(PlaylistRepository.class);
		PlaylistServiceImpl playlistService = new PlaylistServiceImpl();
		playlistService.setPlaylistRepository(mockPlaylistRepository);
		playlistController = new PlaylistController();
		playlistController.setPlaylistService(playlistService);
		Mockito.when(mockPlaylistRepository.findAll()).thenReturn(Arrays.asList(playlist1, playlist2));
		assertEquals(2, Helper.size(playlistController.getPlaylists()));
	}

	@Test
	public void test_playlistController_createPlaylist() throws URISyntaxException {

		PlaylistRepository mockPlaylistRepository = Mockito.mock(PlaylistRepository.class);
		PlaylistServiceImpl playlistService = new PlaylistServiceImpl();
		playlistService.setPlaylistRepository(mockPlaylistRepository);
		playlistController = new PlaylistController();
		playlistController.setPlaylistService(playlistService);
		Mockito.when(mockPlaylistRepository.save(playlist1)).thenReturn(playlist1);
		assertEquals("<204 No Content,{}>", playlistController.createPlaylist(playlist1).toString());
	}

}
