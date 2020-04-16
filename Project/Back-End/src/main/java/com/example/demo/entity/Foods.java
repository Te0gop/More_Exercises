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
@Table(name="foods", schema = "shop_project")
public class Foods {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String name;
	private String expiryDate;
	private String manifactureName;
	private BigDecimal price;
	
	@ManyToOne
	@JoinColumn(name = "shop_id")
	@JsonIgnoreProperties("foods")

	private Shop shop;
	
	public Foods(Long id, String name, String expiryDate, String manifactureName, BigDecimal price) {
		super();
		this.id = id;
		this.name = name;
		this.expiryDate = expiryDate;
		this.manifactureName = manifactureName;
		this.price = price;
	}
	public Foods() { }

	public Long getId() { return id; }

	public void setId(Long id) { this.id = id; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getExpiryDate() { return expiryDate; }

	public void setExpiryDate(String expiryDate) { this.expiryDate = expiryDate; }

	public String getManifactureName() { return manifactureName; }

	public void setManifactureName(String manifactureName) { this.manifactureName = manifactureName;}

	public BigDecimal getPrice() { return price; }

	public void setPrice(BigDecimal price) { this.price = price; }
	
	public Shop getShop() { return shop; }
	
	public void setShop(Shop shop) { this.shop = shop; }
	
	
	
	
}
