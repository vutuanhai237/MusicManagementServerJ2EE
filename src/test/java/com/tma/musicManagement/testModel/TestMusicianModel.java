package com.tma.musicManagement.testModel;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tma.musicManagement.model.Musician;
import com.tma.musicManagement.service.impl.MusicianServiceImpl;
import com.tma.musicManagement.utils.Constant;

@RunWith(SpringJUnit4ClassRunner.class)
public class TestMusicianModel {

	Musician musician;

	@Before
	public void initTest() {
		musician = new Musician();
		musician.setId(1);
		musician.setName("Hoài Linh");
		musician.setSex("Male");
		musician.setBirthday("1990-5-5");
	}

	@Test
	public void test_MusicianModel_getId() {
		assertEquals(1, this.musician.getId());
	}

	@Test
	public void test_MusicianModel_getName() {
		assertEquals("Hoài Linh", this.musician.getName());
	}

	@Test
	public void test_MusicianModel_getSex() {
		assertEquals("Male", this.musician.getSex());
	}

	@Test
	public void test_MusicianModel_getBirthday() {
		assertEquals("1990-5-5", this.musician.getBirthday());
	}

	@Test
	public void test_MusicianModel_toString() {
		assertEquals("Name: Hoài Linh, Sex: Male, birthday: 1990-5-5", this.musician.toString());
	}

	@Test
	public void test_MusicianModel_check_Valid() throws Exception {
		assertEquals(Constant.VALID, MusicianServiceImpl.check(this.musician));
	}

	@Test
	public void test_MusicianModel_check_NameNotValid1() throws Exception {
		this.musician.setName("");
		assertEquals(Constant.NAME_NOT_VALID, MusicianServiceImpl.check(this.musician));
	}

	@Test
	public void test_MusicianModel_check_NameNotValid2() throws Exception {
		this.musician.setName(
				"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		assertEquals(Constant.NAME_NOT_VALID, MusicianServiceImpl.check(this.musician));
	}

	@Test
	public void test_MusicianModel_check_SexNotValid() throws Exception {
		this.musician.setSex("Fe");
		assertEquals(Constant.SEX_NOT_VALID, MusicianServiceImpl.check(this.musician));

	}

	@Test
	public void test_MusicianModel_check_null() throws Exception {
		try {
			this.musician.setName(null);
			MusicianServiceImpl.check(this.musician);
		} catch (Exception e) {
			assertEquals(e.getMessage(), Constant.MUSICIAN_NULL);

		}
	}

}
