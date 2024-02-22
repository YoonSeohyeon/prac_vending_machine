package com.newpla.vm.domain.product.manager;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.newpla.vm.domain.product.entity.Product;

public interface ProductManager {

	@Transactional(readOnly = true)
	Optional<Product> findById(String id);

	@Transactional(readOnly = true)
	List<Product> findOrderBySeq();

	@Transactional
	Product save(Product product);

}
