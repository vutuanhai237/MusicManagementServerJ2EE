package com.tma.musicManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tma.musicManagement.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	// @Query("select m.id from Music as m, User as p where m.id=p.music_id and
	// p.user_id=1")
	@Query("select m.id from Music as m")
	List<?> getMusicsByUId(int id);

}
