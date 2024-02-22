package com.newpla.vm.domain.product.manager;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.newpla.vm.domain.product.entity.Product;

@Component
public class ProductManagerImpl implements ProductManager {

	@Autowired
	ProductRepo repo;

	@Override
	public Optional<Product> findById(String id) {
		return repo.findById(id);
	}

	@Override
	public List<Product> findOrderBySeq() {
		return repo.findAll(Sort.by(Sort.Direction.ASC, "seq"));
	}

	@Override
	public Product save(Product product) {
		return repo.save(product);
	}

}
