package com.Sec_C.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Sec_C.model.Order;
import com.Sec_C.repo.OrderRepo;

@RestController
@RequestMapping("/admin/orders")
public class AdminController {
	  private final OrderRepo orderRepository;
	  
		public AdminController(OrderRepo orderRepository) {
		this.orderRepository = orderRepository;
		}
 
    /**
     * GET /admin/orders
     * Lists every order in the system.
     */
    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
 
    /**
     * DELETE /admin/orders/{id}
     * Deletes an order by ID. Returns 204 on success, 404 if it
     * didn't exist in the first place.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        if (!orderRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        orderRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}