package com.Sec_C.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Sec_C.model.Order;

public interface OrderRepo extends JpaRepository<Order, Long> {

}
