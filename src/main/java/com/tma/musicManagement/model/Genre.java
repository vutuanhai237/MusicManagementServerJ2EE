package com.tma.musicManagement.model;

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
@Table(name = "Genre")
@Component
public class Genre {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;
	@Column(name = "NAME")
	private String name;
	@Autowired
	@OneToMany(mappedBy = "genre", cascade = CascadeType.ALL)
	private List<Music> musics;

	public Genre() {
		this.name = "";
	}

	public String toString() {
		return "Name: " + this.name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String check() throws Exception {
		try {
			if (this.getName().length() < 100 || this.getName().length() > 1) {
				return Constant.VALID;
			}
			return Constant.GENRE_NOT_VALID;
		} catch (Exception e) {
			throw new Exception(Constant.GENRE_NULL);
		}

	}
}