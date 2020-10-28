package com.tma.musicManagement.model;

import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tma.musicManagement.utils.Constant;

@Entity
@Table(name = "Singer")
@Component
public class Singer {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "SEX")
	private String sex;
	@Column(name = "BIRTHDAY")
	private String birthday;
	@Autowired
	@OneToMany(mappedBy = "singer", cascade = CascadeType.ALL)
	private List<Music> musics;

	public Singer() {
		this.name = "";
	}

	public String toString() {
		return "Name: " + this.name + ", Sex: " + this.sex + ", birthday: " + this.birthday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String check() throws Exception {
		try {
			if (this.getName().length() < 1 || this.getName().length() > 50) {
				return Constant.NAME_NOT_VALID;
			} else if (Arrays.stream(Constant.SEXS).anyMatch(this.getSex()::equals) == false) {
				return Constant.SEX_NOT_VALID;
			}
			return Constant.VALID;
		} catch (Exception e) {
			return Constant.MUSICIAN_NULL;
		}

	}
}