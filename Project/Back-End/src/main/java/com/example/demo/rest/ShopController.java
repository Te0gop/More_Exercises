package com.example.demo.rest; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.demo.entity.Drinks;
import com.example.demo.entity.Foods;
import com.example.demo.entity.Shop;
import com.example.demo.repository.DrinksRepository;
import com.example.demo.repository.FoodRepository;
import com.example.demo.repository.ShopRepository;

@Controller
public class ShopController {
	
	@Autowired
	private ShopRepository shopRepository;
	
	@Autowired
	private FoodRepository foodRepository;
	
	@Autowired
	private DrinksRepository drinksRepository;
	
	
	@RequestMapping(value = "shop", method = RequestMethod.POST)
	public ResponseEntity<Shop> createShop(@RequestBody Shop shop) {
		shopRepository.save(shop);
		
		for(Foods food : shop.getFoods()) {
			food.setShop(shop);
			foodRepository.save(food);
		}
		
		for(Drinks drinks : shop.getDrinks()) {
			drinks.setShop(shop);
			drinksRepository.save(drinks);
		}
		
		return new ResponseEntity<Shop>(HttpStatus.OK);
	}
	
}
