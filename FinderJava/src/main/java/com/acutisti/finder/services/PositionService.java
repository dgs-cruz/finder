package com.acutisti.finder.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acutisti.finder.domain.Position;
import com.acutisti.finder.repositories.PositionRepository;

@Service
public class PositionService {
	
	@Autowired
	private PositionRepository repo;
	
	public Position buscar(Integer id) {
		Optional<Position> obj = repo.findById(id);
		return obj.orElse(null);
	}
}
