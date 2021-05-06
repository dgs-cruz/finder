package com.acutisti.finder.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acutisti.finder.domain.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
	List<Car> findByPlacaContainingIgnoreCase(String placa);
}
