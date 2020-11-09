package com.tma.musicManagerment.testController;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tma.musicManagement.controller.GenreController;
import com.tma.musicManagement.dao.GenreDAO;
import com.tma.musicManagement.model.Genre;
import com.tma.musicManagement.repository.GenreRepository;
import com.tma.musicManagement.service.impl.GenreServiceImpl;
import com.tma.musicManagement.utils.Helper;

@RunWith(SpringJUnit4ClassRunner.class)
public class TestGenreService {

	GenreController genreController;
	GenreRepository genreRepository;

	@Before
	public void initTest() {

	}

	@Test
	public void test_GenreController_getGenres() {
		Genre genre1 = new Genre();
		genre1.setName("A");
		Genre genre2 = new Genre();
		genre2.setName("B");
		GenreRepository mockGenreRepository = Mockito.mock(GenreRepository.class);
		GenreServiceImpl genreService = new GenreServiceImpl();
		GenreDAO genreDAO = new GenreDAO();
		genreDAO.setGenreRepository(mockGenreRepository);
		genreService.setGenreDAO(genreDAO);
		genreController = new GenreController();
		genreController.setGenreService(genreService);
		Mockito.when(mockGenreRepository.findAll()).thenReturn(Arrays.asList(genre1, genre2));
		assertEquals(2, Helper.size(genreController.getGenres()));
	}

	@Test
	public void test_GenreController_createGenre() throws URISyntaxException {
		Genre genre = new Genre();
		genre.setId(10);
		genre.setName("AAA");

		GenreRepository mockGenreRepository = Mockito.mock(GenreRepository.class);
		GenreServiceImpl genreService = new GenreServiceImpl();
		GenreDAO genreDAO = new GenreDAO();
		genreDAO.setGenreRepository(mockGenreRepository);
		genreService.setGenreDAO(genreDAO);
		genreController = new GenreController();
		genreController.setGenreService(genreService);

		Mockito.when(mockGenreRepository.save(genre)).thenReturn(genre);

		assertEquals("<204 No Content,{}>", genreController.createGenre(genre).toString());
	}

	@Test
	public void test_GenreController_createGenreCatch() throws URISyntaxException {
		Genre genre = new Genre();
		genre.setId(10);
		genre.setName("AAA");

		GenreRepository mockGenreRepository = Mockito.mock(GenreRepository.class);
		GenreServiceImpl genreService = new GenreServiceImpl();
		GenreDAO genreDAO = new GenreDAO();
		genreDAO.setGenreRepository(mockGenreRepository);
		genreService.setGenreDAO(null);
		genreController = new GenreController();
		genreController.setGenreService(genreService);

		Mockito.when(mockGenreRepository.save(genre)).thenReturn(genre);

		assertEquals("<406 Not Acceptable,Genre is not acceptable,{}>", genreController.createGenre(genre).toString());
	}

	@Test
	public void test_GenreController_createGenre_notValid() throws URISyntaxException {
		Genre genre = new Genre();
		genre.setId(10);
		genre.setName("A");

		GenreRepository mockGenreRepository = Mockito.mock(GenreRepository.class);
		GenreServiceImpl genreService = new GenreServiceImpl();
		GenreDAO genreDAO = new GenreDAO();
		genreDAO.setGenreRepository(mockGenreRepository);
		genreService.setGenreDAO(genreDAO);
		genreController = new GenreController();
		genreController.setGenreService(genreService);

		Mockito.when(mockGenreRepository.save(genre)).thenReturn(genre);

		assertEquals("<406 Not Acceptable,Genre is not valid,{}>", genreController.createGenre(genre).toString());
	}

	@Test
	public void test_GenreController_updateGenre_Valid() {
		Genre genre1 = new Genre();
		genre1.setName("A");
		genre1.setId(10);
		Genre genre2 = new Genre();
		genre2.setName("B");
		genre2.setId(11);

		GenreRepository mockGenreRepository = Mockito.mock(GenreRepository.class);
		GenreServiceImpl genreService = new GenreServiceImpl();
		GenreDAO genreDAO = new GenreDAO();
		genreDAO.setGenreRepository(mockGenreRepository);
		genreService.setGenreDAO(genreDAO);
		genreController = new GenreController();
		genreController.setGenreService(genreService);

		Mockito.when(mockGenreRepository.findOne(11)).thenReturn(genre2);
		genre1.setId(11);
		Mockito.when(mockGenreRepository.save(genre1)).thenReturn(genre1);
		assertEquals("<406 Not Acceptable,Genre is not valid,{}>", genreController.updateGenre(11, genre1).toString());
	}

	@Test
	public void test_GenreController_updateGenreCatch() {
		Genre genre1 = new Genre();
		genre1.setName("A");
		genre1.setId(10);
		Genre genre2 = new Genre();
		genre2.setName("B");
		genre2.setId(11);

		GenreRepository mockGenreRepository = Mockito.mock(GenreRepository.class);
		GenreServiceImpl genreService = new GenreServiceImpl();
		GenreDAO genreDAO = new GenreDAO();
		genreDAO.setGenreRepository(mockGenreRepository);
		genreService.setGenreDAO(null);
		genreController = new GenreController();
		genreController.setGenreService(genreService);

		Mockito.when(mockGenreRepository.findOne(11)).thenReturn(genre2);
		genre1.setId(11);
		Mockito.when(mockGenreRepository.save(genre1)).thenReturn(genre1);
		assertEquals("<406 Not Acceptable,ID or genre is not acceptable,{}>",
				genreController.updateGenre(11, genre1).toString());
	}

	@Test
	public void test_GenreController_updateGenre_NotValid() {
		Genre genre1 = new Genre();
		genre1.setName("A");
		genre1.setId(10);
		Genre genre2 = new Genre();
		genre2.setName("B");
		genre2.setId(11);

		GenreRepository mockGenreRepository = Mockito.mock(GenreRepository.class);
		GenreServiceImpl genreService = new GenreServiceImpl();
		GenreDAO genreDAO = new GenreDAO();
		genreDAO.setGenreRepository(mockGenreRepository);
		genreService.setGenreDAO(genreDAO);
		genreController = new GenreController();
		genreController.setGenreService(genreService);

		Mockito.when(mockGenreRepository.findOne(9)).thenReturn(null);
		assertEquals("<404 Not Found,{}>", genreController.updateGenre(9, genre1).toString());
	}

	@Test
	public void test_GenreController_deleteGenre_Valid() {
		Genre genre1 = new Genre();
		genre1.setName("A");
		genre1.setId(10);
		GenreRepository mockGenreRepository = Mockito.mock(GenreRepository.class);
		GenreServiceImpl genreService = new GenreServiceImpl();
		GenreDAO genreDAO = new GenreDAO();
		genreDAO.setGenreRepository(mockGenreRepository);
		genreService.setGenreDAO(genreDAO);
		genreController = new GenreController();
		genreController.setGenreService(genreService);
		Mockito.when(mockGenreRepository.findOne(10)).thenReturn(genre1);
		assertEquals("<204 No Content,{}>", genreController.deleteGenre(10).toString());
	}

	@Test
	public void test_GenreController_deleteGenre_NotValid() throws Exception {
		GenreRepository mockGenreRepository = Mockito.mock(GenreRepository.class);
		GenreServiceImpl genreService = new GenreServiceImpl();
		GenreDAO genreDAO = new GenreDAO();
		genreDAO.setGenreRepository(mockGenreRepository);
		genreService.setGenreDAO(genreDAO);
		genreController = new GenreController();
		genreController.setGenreService(genreService);
		Mockito.when(mockGenreRepository.findOne(10)).thenReturn(null);
		assertEquals("<404 Not Found,{}>", genreController.deleteGenre(10).toString());
	}

}
