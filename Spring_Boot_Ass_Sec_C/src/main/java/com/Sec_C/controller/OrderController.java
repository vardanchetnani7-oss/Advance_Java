package com.Sec_C.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Sec_C.model.Order;
import com.Sec_C.repo.OrderRepo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/orders")
public class OrderController {
 
    private final OrderRepo orderRepository;
 
    public OrderController(OrderRepo orderRepository) {
        this.orderRepository = orderRepository;
    }
 
    /**
     * POST /orders
     * Validates the incoming Order (customerName/itemName not blank,
     * quantity >= 1, totalAmount >= 0) before saving. A violation results
     * in a 400 handled by GlobalExceptionHandler, not this method body.
     */
    @PostMapping
    public ResponseEntity<Order> placeOrder(@Valid @RequestBody Order newOrder) {
        Order saved = orderRepository.save(newOrder);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
 
    /**
     * GET /orders/{id}
     * Returns a single order by ID, or 404 if it doesn't exist.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        return orderRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
