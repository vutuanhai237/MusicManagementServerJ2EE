package com.tma.musicManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.tma.musicManagement.model.Playlist;

@Repository
public interface PlaylistRepository extends CrudRepository<Playlist, Integer> {
	// @Query("select m.id from Music as m, User as p where m.id=p.music_id and
	// p.user_id=1")
	@Query("select p.music_id from Playlist as p where p.user_id=?1")
	List<?> getMusicsByUId(int id);

	@Query("delete from Playlist as p where p.user_id=?1 and p.music_id=?2")
	ResponseEntity<Object> deleteByTwoID(int uid, int mid);

}
