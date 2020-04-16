package com.example.demo.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="drinks", schema = "shop_project")
public class Drinks {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String name;
	private BigDecimal price;
	private String manifactureName;
	private double alcoholContent;
	
	@ManyToOne
	@JoinColumn(name = "shop_id")
	@JsonIgnoreProperties("drinks")
	private Shop shop;

	public Drinks(Long id, String name, BigDecimal price, String manifactureName, double alcoholContent) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.manifactureName = manifactureName;
		this.alcoholContent = alcoholContent;
	}
	
	public Drinks() { }

	public Long getId() {return id;}

	public void setId(Long id) {this.id = id;}

	public String getName() {return name;}

	public void setName(String name) {this.name = name;}

	public BigDecimal getPrice() {return price;}

	public void setPrice(BigDecimal price) {this.price = price;}

	public String getManifactureName() {return manifactureName;}

	public void setManifactureName(String manifactureName) {this.manifactureName = manifactureName;}

	public double getAlcoholContent() {return alcoholContent;}

	public void setAlcoholContent(double alcoholContent) {this.alcoholContent = alcoholContent;}
	
	public Shop getShop() { return shop; }

	public void setShop(Shop shop) { this.shop = shop; }
	

}
