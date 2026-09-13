package com.Sec_B.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Sec_B.Model.Menuitems;

@RestController
@RequestMapping("/menu")
public class MenuController {

	
	private final List<Menuitems> menuitems=new CopyOnWriteArrayList<>();
	
	
	private final AtomicLong nextId = new AtomicLong();
	
	
	public MenuController() {
		menuitems.add(new Menuitems(nextId.incrementAndGet(),"Margherita Pizza", new BigDecimal("8.99")));
		menuitems.add(new Menuitems(nextId.incrementAndGet(), "Cheeseburger", new BigDecimal("6.49")));
	    menuitems.add(new Menuitems(nextId.incrementAndGet(), "Caesar Salad", new BigDecimal("5.25")));
	}

	
	@GetMapping
	public List<Menuitems>getMenuItems(){
		return menuitems;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Menuitems>getMenuItemsbyId(@PathVariable Long id){
		Optional<Menuitems>match = menuitems.stream()
				.filter(item -> item.getId().equals(id))
				.findFirst();
		return match
				.map(ResponseEntity::ok)
				 .orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Menuitems> createMenutitems(@RequestBody Menuitems newitem){
		
		
		Menuitems saved =new Menuitems(nextId.incrementAndGet(), newitem.getName(), newitem.getPrice());
		menuitems.add(saved);
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
		
	}
}
