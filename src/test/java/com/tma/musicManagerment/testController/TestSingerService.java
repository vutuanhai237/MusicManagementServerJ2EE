package com.tma.musicManagerment.testController;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tma.musicManagement.controller.SingerController;
import com.tma.musicManagement.dao.SingerDAO;
import com.tma.musicManagement.model.Singer;
import com.tma.musicManagement.repository.SingerRepository;
import com.tma.musicManagement.service.impl.SingerServiceImpl;
import com.tma.musicManagement.utils.Helper;

@RunWith(SpringJUnit4ClassRunner.class)
public class TestSingerService {

	private SingerController singerController;
	private SingerRepository singerRepository;
	private Singer singer1;
	private Singer singer2;

	@Before
	public void initTest() {
		singer1 = new Singer();
		singer1.setName("A");
		singer1.setSex("Male");
		singer1.setBirthday("2002-1-1");
		singer2 = new Singer();
		singer2.setName("B");
		singer2.setSex("Male");
		singer2.setBirthday("2002-1-1");
	}

	@Test
	public void test_singerController_getSingers() {
		SingerRepository mockSingerRepository = Mockito.mock(SingerRepository.class);
		SingerDAO singerDAO = new SingerDAO();
		SingerServiceImpl singerService = new SingerServiceImpl();
		SingerController singerController = new SingerController();
		singerDAO.setSingerRepository(mockSingerRepository);
		singerService.setSingerDAO(singerDAO);
		singerController.setSingerService(singerService);

		Mockito.when(mockSingerRepository.findAll()).thenReturn(Arrays.asList(singer1, singer2));
		assertEquals(2, Helper.size(singerController.getSingers()));
	}

	@Test
	public void test_singerController_createSinger() throws URISyntaxException {
		SingerRepository mockSingerRepository = Mockito.mock(SingerRepository.class);
		SingerDAO singerDAO = new SingerDAO();
		SingerServiceImpl singerService = new SingerServiceImpl();
		SingerController singerController = new SingerController();
		singerDAO.setSingerRepository(mockSingerRepository);
		singerService.setSingerDAO(singerDAO);
		singerController.setSingerService(singerService);

		Mockito.when(mockSingerRepository.save(singer1)).thenReturn(singer1);
		assertEquals("<204 No Content,{}>", singerController.createSinger(singer1).toString());
	}

	@Test
	public void test_singerController_createSingerCatch() throws URISyntaxException {
		SingerRepository mockSingerRepository = Mockito.mock(SingerRepository.class);
		SingerDAO singerDAO = new SingerDAO();
		SingerServiceImpl singerService = new SingerServiceImpl();
		SingerController singerController = new SingerController();
		singerDAO.setSingerRepository(mockSingerRepository);
		singerService.setSingerDAO(null);
		singerController.setSingerService(singerService);

		Mockito.when(mockSingerRepository.save(singer1)).thenReturn(singer1);
		assertEquals("<406 Not Acceptable,Singer is not acceptable,{}>",
				singerController.createSinger(singer1).toString());
	}

	@Test
	public void test_singerController_updateSingerCatch() {
		SingerRepository mockSingerRepository = Mockito.mock(SingerRepository.class);
		SingerDAO singerDAO = new SingerDAO();
		SingerServiceImpl singerService = new SingerServiceImpl();
		SingerController singerController = new SingerController();
		singerDAO.setSingerRepository(mockSingerRepository);
		singerService.setSingerDAO(null);
		singerController.setSingerService(singerService);

		Mockito.when(mockSingerRepository.findOne(11)).thenReturn(singer1);
		singer2.setId(11);
		Mockito.when(mockSingerRepository.save(singer1)).thenReturn(singer1);
		assertEquals("<404 Not Found,{}>", singerController.updateSinger(11, singer2).toString());
	}

	@Test
	public void test_singerController_updateSinger_Valid() {
		SingerRepository mockSingerRepository = Mockito.mock(SingerRepository.class);
		SingerDAO singerDAO = new SingerDAO();
		SingerServiceImpl singerService = new SingerServiceImpl();
		SingerController singerController = new SingerController();
		singerDAO.setSingerRepository(mockSingerRepository);
		singerService.setSingerDAO(singerDAO);
		singerController.setSingerService(singerService);

		Mockito.when(mockSingerRepository.findOne(11)).thenReturn(singer1);
		singer2.setId(11);
		Mockito.when(mockSingerRepository.save(singer1)).thenReturn(singer1);
		assertEquals("<204 No Content,{}>", singerController.updateSinger(11, singer2).toString());
	}

	@Test
	public void test_singerController_updateSinger_NotValid() {
		SingerRepository mockSingerRepository = Mockito.mock(SingerRepository.class);
		SingerDAO singerDAO = new SingerDAO();
		SingerServiceImpl singerService = new SingerServiceImpl();
		SingerController singerController = new SingerController();
		singerDAO.setSingerRepository(mockSingerRepository);
		singerService.setSingerDAO(singerDAO);
		singerController.setSingerService(singerService);

		Mockito.when(mockSingerRepository.findOne(9)).thenReturn(null);
		assertEquals("<404 Not Found,{}>", singerController.updateSinger(9, singer1).toString());
	}

	@Test
	public void test_singerController_deleteSinger_Valid() {
		SingerRepository mockSingerRepository = Mockito.mock(SingerRepository.class);
		SingerDAO singerDAO = new SingerDAO();
		SingerServiceImpl singerService = new SingerServiceImpl();
		SingerController singerController = new SingerController();
		singerDAO.setSingerRepository(mockSingerRepository);
		singerService.setSingerDAO(singerDAO);
		singerController.setSingerService(singerService);

		Mockito.when(mockSingerRepository.findOne(10)).thenReturn(singer1);
		assertEquals("<204 No Content,{}>", singerController.deleteSinger(10).toString());
	}

	@Test
	public void test_GenreController_deleteSinger_NotValid() throws Exception {
		SingerRepository mockSingerRepository = Mockito.mock(SingerRepository.class);
		SingerDAO singerDAO = new SingerDAO();
		SingerServiceImpl singerService = new SingerServiceImpl();
		SingerController singerController = new SingerController();
		singerDAO.setSingerRepository(mockSingerRepository);
		singerService.setSingerDAO(singerDAO);
		singerController.setSingerService(singerService);

		Mockito.when(mockSingerRepository.findOne(10)).thenReturn(null);
		assertEquals("<404 Not Found,{}>", singerController.deleteSinger(10).toString());
	}

	@Test
	public void test_GenreController_getSingerById() throws Exception {
		SingerRepository mockSingerRepository = Mockito.mock(SingerRepository.class);
		SingerDAO singerDAO = new SingerDAO();
		SingerServiceImpl singerService = new SingerServiceImpl();
		SingerController singerController = new SingerController();
		singerDAO.setSingerRepository(mockSingerRepository);
		singerService.setSingerDAO(singerDAO);
		singerController.setSingerService(singerService);

		Mockito.when(mockSingerRepository.findOne(10)).thenReturn(singer1);
		assertEquals("Name: A, Sex: Male, birthday: 2002-1-1", singerController.getSingerById(10).toString());
	}

}
