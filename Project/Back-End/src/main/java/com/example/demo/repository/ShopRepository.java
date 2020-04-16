package com.example.demo.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Shop;

@Repository
public interface ShopRepository extends CrudRepository<Shop, Long> {

	

	

}
