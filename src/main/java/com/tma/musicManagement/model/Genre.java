package com.tma.musicManagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "Genre")
@Component
public class Genre {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;
	@Column(name = "NAME")
	private String name;

	@OneToOne(mappedBy = "genre", fetch = FetchType.EAGER)
	private Music music;

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

}