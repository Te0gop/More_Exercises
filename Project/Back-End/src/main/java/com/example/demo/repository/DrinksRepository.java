package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Drinks;

@Repository
public interface DrinksRepository extends CrudRepository<Drinks, Long>{

	List<Drinks> findDrinksByName(String name);

	Optional<Drinks> findByPrice(BigDecimal price);

	List<Drinks> findByManifactureName(String manifactureName);

	Optional<Drinks> findByAlcoholContent(double alcoholContent);

}
