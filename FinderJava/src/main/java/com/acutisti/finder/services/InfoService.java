package com.acutisti.finder.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acutisti.finder.domain.Car;
import com.acutisti.finder.domain.Info;
import com.acutisti.finder.domain.POI;
import com.acutisti.finder.domain.Position;
import com.acutisti.finder.dto.FiltroDTO;
import com.acutisti.finder.repositories.CarRepository;
import com.acutisti.finder.repositories.POIRepository;
import com.acutisti.finder.repositories.PositionRepository;

@Service
public class InfoService {
	
	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private PositionRepository positionRepository;
	
	@Autowired
	private POIRepository poiRepository;
	
	public List<Info> buscar(FiltroDTO filtro) {
		Info currentInfo = new Info();
		Position lastPosition = new Position();
		List<Car> cars = new ArrayList<>();
		List<Info> infos = new ArrayList<>();
		List<Position> positions = new ArrayList<>();
		boolean near = false;
		boolean lastNear = false;
		
		List<POI> pois = poiRepository.findAll();
		
		if (filtro.getPlaca() != null) {
			cars = carRepository.findByPlacaContainingIgnoreCase(filtro.getPlaca());
		} else {
			cars = carRepository.findAll();
		}
		
		for(Car car : cars) {
			if (filtro.getStartDate() != null && filtro.getEndDate() != null) {
				positions = positionRepository.findAllByCarAndDateBetween(car, filtro.getStartDate(), filtro.getEndDate());
			} else {
				positions = positionRepository.findByCar(car);
			}
			
			positions.sort((o1,o2) -> o1.getDate().compareTo(o2.getDate()));
			
			for(POI poi : pois) {
				for(Position position : positions) {
					double distance = calculateDistance(poi.getLatitude(), poi.getLongitude(), position.getLatitude(), position.getLongitude());
					
					if (distance < poi.getRaio()) {
						near = true;
					} else {
						near = false;
					}
					
					if (near == true && lastNear == false) {
						currentInfo.setStartDate(position.getDate());
						currentInfo.setCar(car);
						currentInfo.setPoi(poi);
						currentInfo.setIgnicao(position.getIgnicao());
						currentInfo.setVelocidade(position.getVelocidade());
					}
					
					if (near == false && lastNear == true) {
						currentInfo.setEndDate(lastPosition.getDate());
						currentInfo.setDuration();
						infos.add(currentInfo);
						
						currentInfo = new Info();
						near = false;
						lastNear = false;
					}
					
					lastNear = near;
					lastPosition = position;
				}
			}
		}
		
		return infos;
	}
	
	private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
		  double theta = lon1 - lon2;
		  double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		  dist = Math.acos(dist);
		  dist = rad2deg(dist);
		  dist = dist * 60 * 1.1515;
		  dist = dist * 1.609344 * 1000;

		  return (dist);
	}

	private double deg2rad(double deg) {
	  return (deg * Math.PI / 180.0);
	}

	private double rad2deg(double rad) {
	  return (rad * 180.0 / Math.PI);
	}
}
