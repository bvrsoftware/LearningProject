package com.bvr.LearningProject.repository;

import java.util.List;

import com.bvr.LearningProject.model.Cards;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CardsRepository extends CrudRepository<Cards, Long> {
	
	List<Cards> findByCustomerId(int customerId);

}
