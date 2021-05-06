package com.acutisti.finder.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acutisti.finder.domain.Car;
import com.acutisti.finder.repositories.CarRepository;

@Service
public class CarService {
	
	@Autowired
	private CarRepository repo;
	
	public Car findById(Integer id) {
		Optional<Car> obj = repo.findById(id);
		return obj.orElse(null);
	}
}
