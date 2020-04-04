package hu.wirthandras.epidemap.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
		
		for(String city : cityNameDistinctService.GetCityNames()) {
			
			GeoNames geonames = Search(city);
			
			if(geonames.getGeonames().size() > 0) {
				GeoName geoName = geonames.getGeonames().get(0);
				
				Marker m = new Marker();
				m.setName(geoName.getName());
				m.setLat(geoName.getLat());
				m.setLng(geoName.getLng());
				result.add(m);
			}
		}
		return result;
	}
}
