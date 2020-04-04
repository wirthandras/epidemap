package hu.wirthandras.epidemap.repository;

import org.springframework.data.repository.CrudRepository;

import hu.wirthandras.epidemap.domain.Place;

public interface PlaceRepository extends CrudRepository<Place, Long> {

	public Place findByPlace(String place);
}
