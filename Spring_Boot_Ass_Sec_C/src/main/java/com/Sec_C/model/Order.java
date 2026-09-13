package com.Sec_C.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "orders")
public class Order {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
 
    @NotBlank(message = "customerName is required")
    @Column(name = "customer_name", nullable = false)
    private String customerName;
 
    @NotBlank(message = "itemName is required")
    @Column(name = "item_name", nullable = false)
    private String itemName;
 
    @NotNull(message = "quantity is required")
    @Min(value = 1, message = "quantity must be at least 1")
    @Column(name = "quantity", nullable = false)
    private Integer quantity;
 
    @NotNull(message = "totalAmount is required")
    @Min(value = 0, message = "totalAmount cannot be negative")
    @Column(name = "total_amount", nullable = false)
    private BigDecimal totalAmount;
 
    public Order() {
    }
 
    public Order(String customerName, String itemName, Integer quantity, BigDecimal totalAmount) {
        this.customerName = customerName;
        this.itemName = itemName;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
    }
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getCustomerName() {
        return customerName;
    }
 
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
 
    public String getItemName() {
        return itemName;
    }
 
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
 
    public Integer getQuantity() {
        return quantity;
    }
 
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
 
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
 
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}