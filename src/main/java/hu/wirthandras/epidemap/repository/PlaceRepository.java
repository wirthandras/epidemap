package hu.wirthandras.epidemap.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import hu.wirthandras.epidemap.domain.Place;

public interface PlaceRepository extends CrudRepository<Place, Long> {

	public Place findByPlace(String place);

	public List<Place> findByPlaceContainingIgnoreCase(String place);
}
