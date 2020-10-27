package com.tma.musicManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tma.musicManagement.model.Music;

@Repository
public interface MusicRepository extends CrudRepository<Music, Integer> {
	@Query("select m.genre, count(*) from Music as m group by m.genre")
	List<?> getGenreQuantities();

	@Query("select m.musician, count(*) from Music as m group by m.musician")
	List<?> getMusicianQuantities();

	@Query("select m.singer, count(*) from Music as m group by m.singer")
	List<?> getSingerQuantities();
}
