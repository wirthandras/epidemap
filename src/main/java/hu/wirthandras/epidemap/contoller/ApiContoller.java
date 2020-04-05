package hu.wirthandras.epidemap.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.wirthandras.epidemap.domain.geonames.Marker;
import hu.wirthandras.epidemap.service.ChartService;
import hu.wirthandras.epidemap.service.GeoNameService;
import hu.wirthandras.epidemap.service.LivesearchService;

@RestController
public class ApiContoller {

	@Autowired
	private ChartService service;

	@Autowired
	private GeoNameService mapService;

	@Autowired
	private LivesearchService livesearchService;

	@GetMapping("/chart")
	public String chart() {
		return service.getChartValues();
	}

	@PostMapping("/api/mapdata")
	public List<Marker> refreshMapData() {
		return mapService.GetMarkers();
	}

	@PostMapping("/api/livesearch/city")
	public List<String> livesearchCiy(String pattern) {
		return livesearchService.livesearchCity(pattern);
	}

}
