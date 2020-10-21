package com.tma.musicManagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tma.musicManagement.model.Musician;

@Repository
public interface MusicianRepository extends CrudRepository<Musician, Integer> {

}
