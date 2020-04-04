package hu.wirthandras.epidemap.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.wirthandras.epidemap.domain.Disease;

@Service
public class CityDistictService {

	@Autowired
	private DiseaseService diseaseService;
	
	public List<String> GetCityNames() {
		Set<String> cityNames = new HashSet<>();
		
		for(Disease o : diseaseService.getAll()) {
			cityNames.add(o.getPlace());
		}
		return new ArrayList<String>(cityNames);
	}
}
