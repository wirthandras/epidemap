package hu.wirthandras.epidemap.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.wirthandras.epidemap.domain.Place;
import hu.wirthandras.epidemap.repository.PlaceRepository;

@Service
public class LivesearchService {

	@Autowired
	private PlaceRepository repo;

	public List<String> livesearchCity(String pattern) {
		List<String> result = new ArrayList<String>();
		for (Place p : repo.findByPlaceContainingIgnoreCase(pattern)) {
			result.add(p.getPlace());
		}
		return result;
	}
}
