package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Foods;

@Repository
public interface FoodRepository extends CrudRepository<Foods, Long> {

	List<Foods> findFoodByName(String name);


	Optional<Foods> findByPrice(BigDecimal price);


	List<Foods> findFoodByManifactureName(String manifactureName);


	List<Foods> findFoodByExpiryDate(String expiryDate);

}
