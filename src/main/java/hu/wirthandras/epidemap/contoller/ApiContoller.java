package hu.wirthandras.epidemap.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.wirthandras.epidemap.domain.geonames.GeoNames;
import hu.wirthandras.epidemap.domain.geonames.Marker;
import hu.wirthandras.epidemap.service.ChartService;
import hu.wirthandras.epidemap.service.GeoNameService;

@RestController
public class ApiContoller {

	@Autowired
	private ChartService service;

	@Autowired
	private GeoNameService mapService;

	@GetMapping("/chart")
	public String chart() {
		return service.getChartValues();
	}

	@GetMapping("/mapdata")
	public GeoNames mapdata(String city) {
		return mapService.Search(city);
	}

	@PostMapping("/api/mapdata")
	public List<Marker> refreshMapData() {
		return mapService.GetMarkers();
	}

}
