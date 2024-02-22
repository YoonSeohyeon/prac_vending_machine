package com.newpla.vm.seller.product;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public interface SellerProductService {

	@Transactional(readOnly = true)
	public List<ProductDto> findAll();
	
	@Transactional(readOnly = true)
	public ProductDto findById(String id);
	
	@Transactional
	public ProductDto create(ProductDto dto);
	
	@Transactional
	public ProductDto update(String id, ProductDto dto);
	
	@Transactional
	public ProductDto updateStock(String id, int stock);
}
