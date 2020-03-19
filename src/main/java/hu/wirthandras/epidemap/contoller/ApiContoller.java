package hu.wirthandras.epidemap.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.wirthandras.epidemap.service.ChartService;

@RestController
public class ApiContoller {

	@Autowired
	private ChartService service;
	
	@GetMapping("/chart")
	public String chart() {
		return service.getChartValues();
	}
}
