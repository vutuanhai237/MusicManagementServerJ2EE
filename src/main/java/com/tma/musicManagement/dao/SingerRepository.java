package com.tma.musicManagement.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tma.musicManagement.model.Singer;

@Repository
public interface SingerRepository extends CrudRepository<Singer, Integer> {

}
