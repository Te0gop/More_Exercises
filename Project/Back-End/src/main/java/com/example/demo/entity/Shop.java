package com.example.demo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Shop {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String shopName;
	
	@OneToMany
	private List<Foods> foods;
	
	@OneToMany
	private List<Drinks> drinks;
	
	
	public Shop(long id, String shopName, List<Foods> foods, List<Drinks> drinks) {
		super();
		this.id = id;
		this.shopName = shopName;
		this.foods = foods;
		this.drinks = drinks;
	}
	
	public Shop() { }

	public long getId() { return id; }

	public void setId(long id) { this.id = id; }

	public String getShopName() { return shopName; }

	public void setShopName(String shopName) { this.shopName = shopName; }

	public List<Foods> getFoods() { return foods; }

	public void setFoods(List<Foods> foods) { this.foods = foods; }

	public List<Drinks> getDrinks() { return drinks; }


	public void setDrinks(List<Drinks> drinks) { this.drinks = drinks; }
	
}
