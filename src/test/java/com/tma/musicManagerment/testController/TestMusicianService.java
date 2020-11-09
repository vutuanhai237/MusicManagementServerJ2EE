package com.tma.musicManagerment.testController;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tma.musicManagement.controller.MusicianController;
import com.tma.musicManagement.dao.MusicianDAO;
import com.tma.musicManagement.model.Musician;
import com.tma.musicManagement.repository.MusicianRepository;
import com.tma.musicManagement.service.impl.MusicianServiceImpl;
import com.tma.musicManagement.utils.Helper;

@RunWith(SpringJUnit4ClassRunner.class)
public class TestMusicianService {

	private MusicianController musicianController;
	private MusicianRepository musicianRepository;
	private Musician musician1;
	private Musician musician2;

	@Before
	public void initTest() {
		musician1 = new Musician();
		musician1.setName("A");
		musician1.setSex("Male");
		musician1.setBirthday("2002-1-1");
		musician2 = new Musician();
		musician2.setName("B");
		musician2.setSex("Male");
		musician2.setBirthday("2002-1-1");
	}

	@Test
	public void test_MusicianController_getMusicians() {

		MusicianRepository mockMusicianRepository = Mockito.mock(MusicianRepository.class);
		MusicianDAO musicianDAO = new MusicianDAO();
		MusicianServiceImpl musicianService = new MusicianServiceImpl();
		musicianController = new MusicianController();
		musicianDAO.setMusicianRepository(mockMusicianRepository);
		musicianService.setMusicianDAO(musicianDAO);
		musicianController.setMusicianService(musicianService);
		Mockito.when(mockMusicianRepository.findAll()).thenReturn(Arrays.asList(musician1, musician2));
		assertEquals(2, Helper.size(musicianController.getMusicians()));
	}

	@Test
	public void test_MusicianController_createMusician() throws URISyntaxException {

		MusicianRepository mockMusicianRepository = Mockito.mock(MusicianRepository.class);
		MusicianDAO musicianDAO = new MusicianDAO();
		MusicianServiceImpl musicianService = new MusicianServiceImpl();
		musicianController = new MusicianController();
		musicianDAO.setMusicianRepository(mockMusicianRepository);
		musicianService.setMusicianDAO(musicianDAO);
		musicianController.setMusicianService(musicianService);
		Mockito.when(mockMusicianRepository.save(musician1)).thenReturn(musician1);
		assertEquals("<204 No Content,{}>", musicianController.createMusician(musician1).toString());
	}

	@Test
	public void test_MusicianController_createMusicianCatch() throws URISyntaxException {

		MusicianRepository mockMusicianRepository = Mockito.mock(MusicianRepository.class);
		MusicianDAO musicianDAO = new MusicianDAO();
		MusicianServiceImpl musicianService = new MusicianServiceImpl();
		musicianController = new MusicianController();
		musicianDAO.setMusicianRepository(mockMusicianRepository);
		musicianService.setMusicianDAO(null);
		musicianController.setMusicianService(musicianService);
		Mockito.when(mockMusicianRepository.save(musician1)).thenReturn(musician1);
		assertEquals("<406 Not Acceptable,Musician is not acceptable,{}>",
				musicianController.createMusician(musician1).toString());
	}

	@Test
	public void test_MusicianController_updateMusician_Valid() {

		MusicianRepository mockMusicianRepository = Mockito.mock(MusicianRepository.class);
		MusicianDAO musicianDAO = new MusicianDAO();
		MusicianServiceImpl musicianService = new MusicianServiceImpl();
		musicianController = new MusicianController();
		musicianDAO.setMusicianRepository(mockMusicianRepository);
		musicianService.setMusicianDAO(musicianDAO);
		musicianController.setMusicianService(musicianService);
		Mockito.when(mockMusicianRepository.findOne(11)).thenReturn(musician1);
		musician2.setId(11);
		Mockito.when(mockMusicianRepository.save(musician1)).thenReturn(musician1);
		assertEquals("<204 No Content,{}>", musicianController.updateMusician(11, musician2).toString());
	}

	@Test
	public void test_MusicianController_updateMusician_Catch() {

		MusicianRepository mockMusicianRepository = Mockito.mock(MusicianRepository.class);
		MusicianDAO musicianDAO = new MusicianDAO();
		MusicianServiceImpl musicianService = new MusicianServiceImpl();
		musicianController = new MusicianController();
		musicianDAO.setMusicianRepository(mockMusicianRepository);
		musicianService.setMusicianDAO(null);
		musicianController.setMusicianService(musicianService);
		Mockito.when(mockMusicianRepository.findOne(11)).thenReturn(musician1);
		musician2.setId(11);
		Mockito.when(mockMusicianRepository.save(musician1)).thenReturn(musician1);

		try {

			assertEquals("<406 Not Acceptable,ID or musician is not acceptable,{}>",
					musicianController.updateMusician(11, musician2).toString());

		} catch (Exception e) {

		}
	}

	@Test
	public void test_MusicianController_updateMusician_NotValid() {

		MusicianRepository mockMusicianRepository = Mockito.mock(MusicianRepository.class);
		MusicianDAO musicianDAO = new MusicianDAO();
		MusicianServiceImpl musicianService = new MusicianServiceImpl();
		musicianController = new MusicianController();
		musicianDAO.setMusicianRepository(mockMusicianRepository);
		musicianService.setMusicianDAO(musicianDAO);
		musicianController.setMusicianService(musicianService);

		Mockito.when(mockMusicianRepository.findOne(9)).thenReturn(null);
		assertEquals("<404 Not Found,{}>", musicianController.updateMusician(9, musician1).toString());
	}

	@Test
	public void test_MusicianController_deleteMusician_Valid() {

		MusicianRepository mockMusicianRepository = Mockito.mock(MusicianRepository.class);
		MusicianDAO musicianDAO = new MusicianDAO();
		MusicianServiceImpl musicianService = new MusicianServiceImpl();
		musicianController = new MusicianController();
		musicianDAO.setMusicianRepository(mockMusicianRepository);
		musicianService.setMusicianDAO(musicianDAO);
		musicianController.setMusicianService(musicianService);
		Mockito.when(mockMusicianRepository.findOne(10)).thenReturn(musician1);
		assertEquals("<204 No Content,{}>", musicianController.deleteMusician(10).toString());
	}

	@Test
	public void test_MusicianController_deleteMusicianCatch() {

		MusicianRepository mockMusicianRepository = Mockito.mock(MusicianRepository.class);
		MusicianDAO musicianDAO = new MusicianDAO();
		MusicianServiceImpl musicianService = new MusicianServiceImpl();
		musicianController = new MusicianController();
		musicianDAO.setMusicianRepository(mockMusicianRepository);
		musicianService.setMusicianDAO(null);
		musicianController.setMusicianService(musicianService);
		Mockito.when(mockMusicianRepository.findOne(10)).thenReturn(musician1);
		assertEquals("<406 Not Acceptable,ID musician is not acceptable,{}>",
				musicianController.deleteMusician(10).toString());
	}

	@Test
	public void test_GenreController_deleteGenre_NotValid() throws Exception {
		MusicianRepository mockMusicianRepository = Mockito.mock(MusicianRepository.class);
		MusicianDAO musicianDAO = new MusicianDAO();
		MusicianServiceImpl musicianService = new MusicianServiceImpl();
		musicianController = new MusicianController();
		musicianDAO.setMusicianRepository(mockMusicianRepository);
		musicianService.setMusicianDAO(musicianDAO);
		musicianController.setMusicianService(musicianService);
		Mockito.when(mockMusicianRepository.findOne(10)).thenReturn(null);
		assertEquals("<404 Not Found,{}>", musicianController.deleteMusician(10).toString());
	}

}
