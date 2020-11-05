package com.tma.musicManagement.testModel;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tma.musicManagement.model.Genre;
import com.tma.musicManagement.service.impl.GenreServiceImpl;
import com.tma.musicManagement.utils.Constant;

@RunWith(SpringJUnit4ClassRunner.class)
public class TestGenreModel {

	Genre genre;
	GenreServiceImpl genreServiceImpl;

	@Before
	public void initTest() {
		genreServiceImpl = new GenreServiceImpl();
		genre = new Genre();
		genre.setId(1);
		genre.setName("Trẻ");
	}

	@Test
	public void test_GenreModel_getGenreName() {
		assertEquals("Trẻ", this.genre.getName());
	}

	@Test
	public void test_GenreModel_getGenreId() {
		assertEquals(1, this.genre.getId());
	}

	@Test
	public void test_GenreModel_toString() {
		assertEquals("Name: Trẻ", this.genre.toString());
	}

	@Test
	public void test_GenreModel_check_Valid() throws Exception {
		assertEquals(Constant.VALID, genreServiceImpl.check(this.genre));
	}

	@Test
	public void test_GenreModel_check_notValid1() throws Exception {
		this.genre.setName("");
		assertEquals(Constant.GENRE_NOT_VALID, genreServiceImpl.check(this.genre));
	}

	@Test
	public void test_GenreModel_check_notValid2() throws Exception {
		this.genre.setName(
				"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		assertEquals(Constant.GENRE_NOT_VALID, genreServiceImpl.check(this.genre));
	}

	@Test
	public void test_GenreModel_check_null() throws Exception {
		try {
			this.genre.setName(null);
			genreServiceImpl.check(this.genre);
		} catch (Exception e) {
			assertEquals(e.getMessage(), Constant.GENRE_NULL);
		}

	}
}
