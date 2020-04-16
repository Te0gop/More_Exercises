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
import com.example.demo.entity.Drinks;
import com.example.demo.repository.DrinksRepository;

@Controller
public class DrinksController {
	
	@Autowired
	private DrinksRepository drinksRepository;

	@RequestMapping(value="drinks", method = RequestMethod.POST)
	public ResponseEntity<Drinks> addDrink(@RequestBody Drinks drink) {
		drinksRepository.save(drink);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value="drinks", method = RequestMethod.PUT)
	public ResponseEntity<Drinks> updateDrinks(@RequestBody Drinks drink) {
		drinksRepository.save(drink);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	

	@RequestMapping(value = "drinks/{id}", method = RequestMethod.GET)
	public ResponseEntity<Drinks> findDrinkById(@PathVariable("id") Long id) {
		
		Optional<Drinks> optional = drinksRepository.findById(id);
		
		if(optional.isPresent()) {
			return new ResponseEntity<>(optional.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(optional.get(), HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "drinks/name/{name}", method = RequestMethod.GET)
	public ResponseEntity<List<Drinks>> findDrinksByName(@PathVariable("name") String name) {
		List<Drinks> drinkName = drinksRepository.findDrinksByName(name);
		
		if(drinkName.isEmpty()) {
			return new ResponseEntity<>(drinkName, HttpStatus.NOT_FOUND);
		} 
		return new ResponseEntity<>(drinkName, HttpStatus.OK);
	}
	
	@RequestMapping(value = "drinks/price/{price}", method = RequestMethod.GET)
	public ResponseEntity<Drinks> findDrinksByPrice(@PathVariable("price") BigDecimal price) {
		Optional<Drinks> optional = drinksRepository.findByPrice(price);
		
		if(optional.isPresent()) {
			return new ResponseEntity<>(optional.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(optional.get(), HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "drinks/manifactureName/{manifactureName}", method = RequestMethod.GET)
	public ResponseEntity<List<Drinks>> findDrinksByManifactureName(@PathVariable("manifactureName") String manifactureName) {
		List<Drinks> name = drinksRepository.findByManifactureName(manifactureName);
		
		if(name.isEmpty()) {
			return new ResponseEntity<>(name, HttpStatus.NOT_FOUND);
		} 
		return new ResponseEntity<>(name, HttpStatus.OK);
	}
	
	@RequestMapping(value = "drinks/alcoholContent/{alcoholContent}", method = RequestMethod.GET)
	public ResponseEntity<Drinks> findDrinksByAlcoholContent(@PathVariable("alcoholContent") double alcoholContent) {
		Optional<Drinks> optional = drinksRepository.findByAlcoholContent(alcoholContent);
		
		if(optional.isPresent()) {
			return new ResponseEntity<>(optional.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(optional.get(), HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "drinks", method = RequestMethod.GET)
	public ResponseEntity<List<Drinks>> findAll() {
		List<Drinks> drinks = new ArrayList<>();
		drinksRepository.findAll().forEach(x -> drinks.add(x));
		
		return new ResponseEntity<>(drinks, HttpStatus.OK);
	}
	
	@RequestMapping(value="drinks/{id}", method = RequestMethod.DELETE) 
	public ResponseEntity<?> deleteById(@PathVariable("id") Long id ) {
		drinksRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
