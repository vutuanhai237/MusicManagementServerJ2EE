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
import com.tma.musicManagement.dao.PlaylistDAO;
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
		PlaylistDAO playlistDAO = new PlaylistDAO();
		playlistController = new PlaylistController();
		playlistDAO.setPlaylistRepository(mockPlaylistRepository);
		playlistService.setPlaylistDAO(playlistDAO);
		playlistController.setPlaylistService(playlistService);

		Mockito.when(mockPlaylistRepository.findAll()).thenReturn(Arrays.asList(playlist1, playlist2));
		assertEquals(2, Helper.size(playlistController.getPlaylists()));
	}

	@Test
	public void test_playlistController_createPlaylist() throws URISyntaxException {

		PlaylistRepository mockPlaylistRepository = Mockito.mock(PlaylistRepository.class);
		PlaylistServiceImpl playlistService = new PlaylistServiceImpl();
		PlaylistDAO playlistDAO = new PlaylistDAO();
		playlistController = new PlaylistController();
		playlistDAO.setPlaylistRepository(mockPlaylistRepository);
		playlistService.setPlaylistDAO(playlistDAO);
		playlistController.setPlaylistService(playlistService);
		Mockito.when(mockPlaylistRepository.save(playlist1)).thenReturn(playlist1);
		assertEquals("<204 No Content,{}>", playlistController.createPlaylist(playlist1).toString());
	}

	@Test
	public void test_playlistController_getPlaylistByUid() throws URISyntaxException {

		PlaylistRepository mockPlaylistRepository = Mockito.mock(PlaylistRepository.class);
		PlaylistServiceImpl playlistService = new PlaylistServiceImpl();
		PlaylistDAO playlistDAO = new PlaylistDAO();
		playlistController = new PlaylistController();
		playlistDAO.setPlaylistRepository(mockPlaylistRepository);
		playlistService.setPlaylistDAO(playlistDAO);
		playlistController.setPlaylistService(playlistService);
		assertEquals("[]", playlistController.getPlaylistByUId(1).toString());
	}

	@Test
	public void test_playlistController_deleteByTwoId() throws URISyntaxException {

		PlaylistRepository mockPlaylistRepository = Mockito.mock(PlaylistRepository.class);
		PlaylistServiceImpl playlistService = new PlaylistServiceImpl();
		PlaylistDAO playlistDAO = new PlaylistDAO();
		playlistController = new PlaylistController();
		playlistDAO.setPlaylistRepository(mockPlaylistRepository);
		playlistService.setPlaylistDAO(playlistDAO);
		playlistController.setPlaylistService(playlistService);

		Mockito.doThrow(new IllegalArgumentException()).when(mockPlaylistRepository).deleteByTwoID(1, 1);
		try {
			playlistController.deletePlaylistByTwoId(1, 1);

		} catch (IllegalArgumentException e) {
			// Expected
		}
	}

	@Test
	public void test_playlistController_createPlaylistCatch() throws URISyntaxException {

		PlaylistRepository mockPlaylistRepository = Mockito.mock(PlaylistRepository.class);
		PlaylistServiceImpl playlistService = new PlaylistServiceImpl();
		PlaylistDAO playlistDAO = new PlaylistDAO();
		playlistController = new PlaylistController();
		playlistDAO.setPlaylistRepository(mockPlaylistRepository);
		playlistService.setPlaylistDAO(null);
		playlistController.setPlaylistService(playlistService);

		try {

			assertEquals("<406 Not Acceptable,Playlist is not acceptable,{}>",
					playlistController.createPlaylist(new Playlist()).toString());
		} catch (IllegalArgumentException e) {
			// Expected
		}
	}

	@Test
	public void test_playlistController_getPlaylistCatch() throws URISyntaxException {

		PlaylistRepository mockPlaylistRepository = Mockito.mock(PlaylistRepository.class);
		PlaylistServiceImpl playlistService = new PlaylistServiceImpl();
		PlaylistDAO playlistDAO = new PlaylistDAO();
		playlistController = new PlaylistController();
		playlistDAO.setPlaylistRepository(mockPlaylistRepository);
		playlistService.setPlaylistDAO(null);
		playlistController.setPlaylistService(playlistService);

		try {

			assertEquals(null, playlistController.getPlaylists());
		} catch (IllegalArgumentException e) {
			// Expected
		}
	}

}
