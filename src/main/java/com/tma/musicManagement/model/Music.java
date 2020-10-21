package com.tma.musicManagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "Music")
@Component
public class Music {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "RELEASE_TIME")
	private String releaseTime;
	@Autowired
	@ManyToOne
	@JoinColumn(name = "genre_id")
	private Genre genre;
	@Autowired
	@ManyToOne
	@JoinColumn(name = "musician_id")
	private Musician musician;
	@Autowired
	@ManyToOne
	@JoinColumn(name = "singer_id")
	private Singer singer;

	@Autowired
	public Singer getSinger() {
		return this.singer;
	}

	public void setSinger(Singer singer) {
		this.singer = singer;
	}

	public Music(Singer singer) {
		this.setSinger(singer);
	}

	@Autowired
	public Genre getGenre() {
		return this.genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Music(Genre genre) {
		this.setGenre(genre);
	}

	@Autowired
	public Musician getMusician() {
		return this.musician;
	}

	public void setMusician(Musician musician) {
		this.musician = musician;
	}

	public Music(Musician musician) {
		this.setMusician(musician);
	}

	public Music() {
		this.name = "";
		this.releaseTime = "2000-1-1";
	}

	public String toString() {
		String result = "";
		result = "Name: " + this.getName() + ", release time: " + this.getReleaseTime();
		return result;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReleaseTime() {
		return this.releaseTime;
	}

	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}

}
