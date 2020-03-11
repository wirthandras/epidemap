package hu.wirthandras.epidemap.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hu.wirthandras.epidemap.domain.Disease;

@Repository
public interface DiseaseRepository extends CrudRepository<Disease, Long> {

	List<Disease> findAll();
}
