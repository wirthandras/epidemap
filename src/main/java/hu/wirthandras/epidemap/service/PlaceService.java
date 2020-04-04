package hu.wirthandras.epidemap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.wirthandras.epidemap.domain.Place;
import hu.wirthandras.epidemap.repository.PlaceRepository;

@Service
public class PlaceService {

	@Autowired
	private PlaceRepository repo;
	
	public Place GetPlace(String place) {
		return repo.findByPlace(place);
	}
	
	public void Save(Place place) {
		repo.save(place);
	}
}
