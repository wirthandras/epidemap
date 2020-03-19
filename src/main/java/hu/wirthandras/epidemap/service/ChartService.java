package hu.wirthandras.epidemap.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.wirthandras.epidemap.domain.Disease;
import hu.wirthandras.epidemap.repository.DiseaseRepository;

@Service
public class ChartService {

	@Autowired
	private DiseaseRepository repository;
	
	public String getChartValues() {
		Map<String, Map<String, Integer>> counters = new HashMap<>();
		
		
		for(Disease d : repository.findAll()) {
			if(counters.containsKey(d.name)) {
				Map<String, Integer> mutation = counters.get(d.name);
				if(mutation.containsKey(d.place)) {
					mutation.put(d.place, mutation.get(d.place) + 1);
				}
				else {
					mutation.put(d.place, 1);
				}
			} else {
				Map<String, Integer> mutation = new HashMap<>();
				mutation.put(d.place, 1);
				counters.put(d.name, mutation);
			}
		}
		
		StringBuilder sb = new StringBuilder("[[\"Hely\"");
		for(String mutation : counters.keySet()) {
			sb.append(", \"" + mutation + "\"");
		}
		sb.append("]");
		
		Map<String, Map<String, Integer>> reverse = new HashMap<>();
		for(String mutation : counters.keySet()) {
			Map<String, Integer> mutationMap = counters.get(mutation);
			for(String city : mutationMap.keySet()) {
				
				if(reverse.containsKey(city)) {
					Map<String, Integer> citiesMap = reverse.get(city);
					if(citiesMap.containsKey(mutation)) {
						citiesMap.put(mutation, citiesMap.get(mutation) + 1);
					} else {
						citiesMap.put(mutation, mutationMap.get(city));
					}					
				} else {
					Map<String, Integer> mutationMap2 = new HashMap<>();
					mutationMap2.put(mutation, mutationMap.get(city));
					reverse.put(city, mutationMap2);
				}
			}
		}
		
		for(String city : reverse.keySet()) {
			
			sb.append(",[\"" + city + "\"");
			Map<String, Integer> rr = reverse.get(city);
			
			for(String mutation : counters.keySet()) {
				if(!rr.keySet().contains(mutation)) {
					rr.put(mutation, 0);
				}
			}
			
			
			for(String m : rr.keySet()) {
				sb.append(", " + rr.get(m));
			}
			sb.append("]");
		}
		sb.append("]");
		
		return sb.toString();
		//return "[[\"Hely\", \"AML M4\", \"ALL\"],[\"Makó\", 1, 3],[\"Szeged\", 2, 2]]";
	}
}
