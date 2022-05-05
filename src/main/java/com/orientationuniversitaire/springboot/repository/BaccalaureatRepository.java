package com.orientationuniversitaire.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orientationuniversitaire.springboot.entity.Baccalaureats;

@Repository
public interface BaccalaureatRepository extends JpaRepository<Baccalaureats, Integer> {

}
