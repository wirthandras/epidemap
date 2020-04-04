package hu.wirthandras.epidemap.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import hu.wirthandras.epidemap.domain.Place;
import hu.wirthandras.epidemap.domain.geonames.GeoName;
import hu.wirthandras.epidemap.domain.geonames.GeoNames;
import hu.wirthandras.epidemap.domain.geonames.Marker;

/**
 * https://www.geonames.org/
 * 
 * @author Andras Wirth
 *
 */
@Service
public class GeoNameService {

	@Value("${geonames.url}")
	private String url;

	@Value("${geonames.username}")
	private String username;

	@Autowired
	private CityDistictService cityNameDistinctService;

	@Autowired
	private PlaceService placeService;

	private RestTemplate restTemplate = new RestTemplate();

	public GeoNames Search(String city) {
		String query = url + "?q=" + city + "+hungary&username=" + username;
		return restTemplate.getForObject(query, GeoNames.class);
	}

	RestTemplate getRestTemplate() {
		return restTemplate;
	}

	public List<Marker> GetMarkers() {
		List<Marker> result = new ArrayList<>();

		for (String city : cityNameDistinctService.GetCityNames()) {
			Place place = placeService.GetPlace(city);
			if (place != null) {
				result.add(createMarker(place.getPlace(), place.getLat(), place.getLng()));
			} else {
				GeoNames geonames = Search(city);
				if (geonames.getGeonames().size() > 0) {
					GeoName geoName = geonames.getGeonames().get(0);

					placeService.Save(createNewPlace(geoName.getName(), geoName.getLat(), geoName.getLng()));

					result.add(createMarker(geoName.getName(), geoName.getLat(), geoName.getLng()));
				}
			}
		}
		return result;
	}

	public Marker createMarker(String name, String lat, String lng) {
		Marker m = new Marker();
		m.setName(name);
		m.setLat(lat);
		m.setLng(lng);
		return m;
	}

	private Place createNewPlace(String name, String lat, String lng) {
		Place newPlace = new Place();
		newPlace.setPlace(name);
		newPlace.setLat(lat);
		newPlace.setLng(lng);
		return newPlace;
	}
}
