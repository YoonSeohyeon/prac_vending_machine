package com.newpla.vm.domain.product.manager;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.newpla.vm.domain.product.entity.Product;

public interface ProductRepo extends JpaRepository<Product, String> {
	
	//select * from product where name = %@;
	List<Product> findByName(String name);

	
}
