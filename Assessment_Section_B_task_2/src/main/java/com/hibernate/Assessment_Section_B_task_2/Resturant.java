package com.hibernate.Assessment_Section_B_task_2;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "restaurants")
public class Resturant {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
private long id;
@Column(name = "name")
private  String name;
@Column(name = "city")
private String city;
@Column(name = "rating")
private double rating;
@OneToMany(mappedBy="restaurant",cascade=CascadeType.ALL)
private List<MenuItem>menuitem = new ArrayList<>();
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public double getRating() {
	return rating;
}
public void setRating(double rating) {
	this.rating = rating;
}
public List<MenuItem> getMenuitem() {
	return menuitem;
}
public void setMenuitem(List<MenuItem> menuitem) {
	this.menuitem = menuitem;
}
public Resturant( String name, String city, double rating) {
	super();
	
	this.name = name;
	this.city = city;
	this.rating = rating;
	
}
@Override
public String toString() {
	return "Resturant [id=" + id + ", name=" + name + ", city=" + city + ", rating=" + rating + ", menuitem=" + menuitem
			+ "]";
}
public void addMenuItem(MenuItem item) {
    menuitem.add(item);
    item.setRestaurant(this);
}

}
