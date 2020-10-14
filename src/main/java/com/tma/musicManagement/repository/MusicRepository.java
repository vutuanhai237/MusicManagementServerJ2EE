package com.tma.musicManagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tma.musicManagement.model.Music;

@Repository
public interface MusicRepository extends CrudRepository<Music, Integer> {

}
