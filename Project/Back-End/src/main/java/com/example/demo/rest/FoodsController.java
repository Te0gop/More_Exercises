package com.example.demo.rest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.demo.entity.Foods;
import com.example.demo.repository.FoodRepository;

@Controller
public class FoodsController {

	@Autowired
	private FoodRepository foodRepository;
	
	@RequestMapping(value="foods", method = RequestMethod.POST)
	public ResponseEntity<Foods> addFood(@RequestBody Foods food) {
		foodRepository.save(food);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value="foods", method = RequestMethod.PUT)
	public ResponseEntity<Foods> updateFood(@RequestBody Foods food) {
		foodRepository.save(food);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "foods/{id}", method = RequestMethod.GET)
	public ResponseEntity<Foods> findFoodById(@PathVariable("id") Long id) {
		
		Optional<Foods> optional = foodRepository.findById(id);
		
		if(optional.isPresent()) {
			return new ResponseEntity<>(optional.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(optional.get(), HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(value = "foods/name/{name}", method = RequestMethod.GET)
	public ResponseEntity<List<Foods>> findFoodByName(@PathVariable("name") String name) {
		List<Foods> foodName = foodRepository.findFoodByName(name);
		
		if(foodName.isEmpty()) {
			return new ResponseEntity<>(foodName, HttpStatus.NOT_FOUND);
		} 
		return new ResponseEntity<>(foodName, HttpStatus.OK);
	}
	
	@RequestMapping(value = "foods/price/{price}", method = RequestMethod.GET)
	public ResponseEntity<Foods> findFoodByPrice(@PathVariable("price") BigDecimal price) {
		Optional<Foods> optional = foodRepository.findByPrice(price);
		
		if(optional.isPresent()) {
			return new ResponseEntity<>(optional.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(optional.get(), HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "foods/manifactureName/{manifactureName}", method = RequestMethod.GET)
	public ResponseEntity<List<Foods>> findFoodByManifactureName(@PathVariable("manifactureName") String manifactureName) {
		List<Foods> name = foodRepository.findFoodByManifactureName(manifactureName);
		
		if(name.isEmpty()) {
			return new ResponseEntity<>(name, HttpStatus.NOT_FOUND);
		} 
		return new ResponseEntity<>(name, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "foods/expiryDate/{expiryDate}", method = RequestMethod.GET)
	public ResponseEntity<List<Foods>> findFoodByExpiryDate(@PathVariable("expiryDate") String expiryDate) {
		List<Foods> date = foodRepository.findFoodByExpiryDate(expiryDate);
		
		if(date.isEmpty()) {
			return new ResponseEntity<>(date, HttpStatus.NOT_FOUND);
		} 
		return new ResponseEntity<>(date, HttpStatus.OK);
	}
	
	@RequestMapping(value = "foods", method = RequestMethod.GET)
	public ResponseEntity<List<Foods>> findAll() {
		List<Foods> food = new ArrayList<>();
		foodRepository.findAll().forEach(x -> food.add(x));
		
		return new ResponseEntity<>(food, HttpStatus.OK);
	}
	
	@RequestMapping(value="foods/{id}", method = RequestMethod.DELETE) 
	public ResponseEntity<?> deleteById(@PathVariable("id") Long id ) {
		foodRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
