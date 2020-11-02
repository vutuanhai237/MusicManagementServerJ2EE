package com.tma.musicManagement.testModel;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tma.musicManagement.model.Genre;
import com.tma.musicManagement.model.Music;
import com.tma.musicManagement.model.Musician;
import com.tma.musicManagement.model.Singer;
import com.tma.musicManagement.service.impl.MusicServiceImpl;
import com.tma.musicManagement.utils.Constant;

@RunWith(SpringJUnit4ClassRunner.class)
public class TestMusicModel {

	Music music;

	@Before
	public void initTest() {
		music = new Music();
		music.setId(1);
		music.setGenre(new Genre());
		music.setMusician(new Musician());
		music.setSinger(new Singer());
		music.setName("Đen");
		music.setReleaseTime("2020-5-5");
	}

	@Test
	public void test_MusicModel_getGenreName() {
		assertEquals("", this.music.getGenre().getName());
	}

	@Test
	public void test_MusicModel_getSingerName() {
		assertEquals("", this.music.getSinger().getName());
	}

	@Test
	public void test_MusicModel_getMusicianName() {
		assertEquals("", this.music.getMusician().getName());
	}

	@Test
	public void test_MusicModel_getReleaseTime() {
		assertEquals("2020-5-5", this.music.getReleaseTime());
	}

	@Test
	public void test_MusicModel_getId() {
		assertEquals(1, this.music.getId());
	}

	@Test
	public void test_MusicModel_toString() {
		assertEquals("Name: Đen, release time: 2020-5-5", this.music.toString());
	}

	@Test
	public void test_MusicModel_getName() {
		assertEquals("Đen", this.music.getName());
	}

	@Test
	public void test_MusicModel_check_genreNull() throws Exception {
		try {
			music.setGenre(null);
			MusicServiceImpl.check(this.music);
		} catch (Exception e) {
			assertEquals(Constant.GENRE_NULL, e.getMessage());
		}
	}

	@Test
	public void test_MusicModel_check_musicianNull() throws Exception {
		try {
			music.getGenre().setName("Ca");
			music.setMusician(null);
			MusicServiceImpl.check(this.music);
		} catch (Exception e) {
			assertEquals(Constant.MUSICIAN_NULL, e.getMessage());
		}

	}

	@Test
	public void test_MusicModel_check_singerNull() throws Exception {
		try {
			music.getGenre().setName("Ca");
			music.getMusician().setName("Ca");
			music.getMusician().setSex("Male");
			music.setSinger(null);
			MusicServiceImpl.check(this.music);
		} catch (Exception e) {
			assertEquals(Constant.SINGER_NULL, e.getMessage());
		}
	}

}
