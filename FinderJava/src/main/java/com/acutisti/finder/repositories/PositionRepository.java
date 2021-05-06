package com.acutisti.finder.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acutisti.finder.domain.Car;
import com.acutisti.finder.domain.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer> {

	List<Position> findByCar(Car car);
	
	List<Position> findAllByCarAndDateBetween(Car car, Date startDate, Date endDate);
	
//	@Query("select a from Article a where a.creationDateTime <= :creationDateTime")
//    List<Article> findAllWithCreationDateTimeBefore(
//      @Param("creationDateTime") Date creationDateTime);

}
