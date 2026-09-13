package com.Sec_B.repo;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.Sec_B.model.order;

public interface OrderRepo extends CrudRepository<order, Long> {

	
List<order>findByCustomerName(String customerName);
}
