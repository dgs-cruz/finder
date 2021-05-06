package com.acutisti.finder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acutisti.finder.domain.POI;

@Repository
public interface POIRepository extends JpaRepository<POI, Integer> {

}
