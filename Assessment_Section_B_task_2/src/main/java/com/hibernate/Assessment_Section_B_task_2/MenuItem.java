package com.hibernate.Assessment_Section_B_task_2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="menu_items")
public class MenuItem {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "item_name")
	private String itemName;
	@Column(name = "price")
	private double price;
	@Column(name = "available")
	private boolean available;
	@ManyToOne(fetch  = FetchType.LAZY)
	@JoinColumn(name = "resturant_id")
	private Resturant restaurant;
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public Resturant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Resturant restaurant) {
		this.restaurant = restaurant;
	}
	
	public MenuItem( String itemName, double price, boolean available) {
		super();
		
		this.itemName = itemName;
		this.price = price;
		this.available = available;
		
	}
	@Override
	public String toString() {
		return "MenuItem [id=" + id + ", itemName=" + itemName + ", price=" + price + ", available=" + available
				+ ", restaurant=" + restaurant + "]";
	}

}
