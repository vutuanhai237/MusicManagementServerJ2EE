package com.tma.musicManagement.testModel;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tma.musicManagement.model.Singer;
import com.tma.musicManagement.utils.Constant;

@RunWith(SpringJUnit4ClassRunner.class)
public class TestSingerModel {

	Singer singer;

	@Before
	public void initTest() {
		singer = new Singer();
		singer.setId(1);
		singer.setName("Hoài Linh");
		singer.setSex("Male");
		singer.setBirthday("1990-5-5");
	}

	@Test
	public void test_MusicianModel_getId() {
		assertEquals(1, this.singer.getId());
	}

	@Test
	public void test_MusicianModel_getName() {
		assertEquals("Hoài Linh", this.singer.getName());
	}

	@Test
	public void test_MusicianModel_getSex() {
		assertEquals("Male", this.singer.getSex());
	}

	@Test
	public void test_MusicianModel_getBirthday() {
		assertEquals("1990-5-5", this.singer.getBirthday());
	}

	@Test
	public void test_MusicianModel_toString() {
		assertEquals("Name: Hoài Linh, Sex: Male, birthday: 1990-5-5", this.singer.toString());
	}

	@Test
	public void test_MusicianModel_check_Valid() throws Exception {
		assertEquals(Constant.VALID, this.singer.check());
	}

	@Test
	public void test_MusicianModel_check_NameNotValid1() throws Exception {
		this.singer.setName("");
		assertEquals(Constant.NAME_NOT_VALID, this.singer.check());
	}

	@Test
	public void test_MusicianModel_check_NameNotValid2() throws Exception {
		this.singer.setName(
				"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		assertEquals(Constant.NAME_NOT_VALID, this.singer.check());
	}

	@Test
	public void test_MusicianModel_check_SexNotValid() throws Exception {
		this.singer.setSex("Fe");
		assertEquals(Constant.SEX_NOT_VALID, this.singer.check());

	}

	@Test
	public void test_MusicianModel_check_null() throws Exception {
		try {
			this.singer.setName(null);
			this.singer.check();
		} catch (Exception e) {
			assertEquals(e.getMessage(), Constant.MUSICIAN_NULL);

		}
	}

}
