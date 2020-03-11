package hu.wirthandras.epidemap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.wirthandras.epidemap.domain.Disease;
import hu.wirthandras.epidemap.repository.DiseaseRepository;

@Service
public class DiseaseService {

	@Autowired
	private DiseaseRepository repository;
		
	public List<Disease> getAll() {
		return repository.findAll();
	}
	
	public void save(Disease entity) {
		repository.save(entity);
	}
}
