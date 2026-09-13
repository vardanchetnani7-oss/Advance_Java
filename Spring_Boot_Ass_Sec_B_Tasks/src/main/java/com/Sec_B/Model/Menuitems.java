package com.Sec_B.Model;

import java.math.BigDecimal;

public class Menuitems {

	private Long id;
	private String name;
	private BigDecimal price;
	
	
	
	public Menuitems(Long id, String name, BigDecimal price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	public Menuitems() {

	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
	

}
