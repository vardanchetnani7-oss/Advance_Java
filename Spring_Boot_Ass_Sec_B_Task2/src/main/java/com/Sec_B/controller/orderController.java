package com.Sec_B.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Sec_B.model.order;
import com.Sec_B.repo.OrderRepo;

@RestController
@RequestMapping("/orders")
public class orderController {


private final OrderRepo orderRepo;

public orderController(OrderRepo orderRepo) {
	
	this.orderRepo = orderRepo;
}

@GetMapping
public List<order>getAllOrders(){
	
	
	return(List<order>) orderRepo.findAll();
}


@GetMapping("/customer/{customerName}")
public List<order>getAllOrdersbyCustomerName(@PathVariable String customerName){
	
	return orderRepo.findByCustomerName(customerName);
}

@GetMapping("/{id}")
public ResponseEntity<order>getAllOrdersbyId(@PathVariable Long id){
	
	return orderRepo.findById(id)
			.map(ResponseEntity::ok)
			.orElseGet(() -> ResponseEntity.notFound().build());
}

@PostMapping
public ResponseEntity<order>  createOrder(@RequestBody order neworder) {
	order saved = orderRepo.save(neworder);
	return ResponseEntity.status(HttpStatus.CREATED).body(saved);
}


}
