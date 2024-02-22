package com.newpla.vm.core.product;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.newpla.vm.domain.product.entity.Product;

public interface ProductService {

	@Transactional(readOnly = true)
	public List<Product> findAll();

	@Transactional(readOnly = true)
	public List<Product> findByEnable();

	@Transactional(readOnly = true)
	public Product findById(String id);

	@Transactional
	public Product create(Product product);

	@Transactional
	public Product update(Product product);

	@Transactional
	public void test(String id);
	
}
