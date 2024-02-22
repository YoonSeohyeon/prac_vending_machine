package com.newpla.vm.web.api.seller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newpla.vm.core.product.ProductService;
import com.newpla.vm.seller.product.ProductDto;
import com.newpla.vm.seller.product.SellerProductService;

@RestController
@RequestMapping("/api/seller/product")
public class ApiSellerProductController {

	@Autowired
	SellerProductService sellerProductService;
	
	
	@Autowired
	ProductService productService;
	
	@GetMapping
	public List<ProductDto> findAll() {
		return sellerProductService.findAll();
	}
	
	@GetMapping("{id}")
	public ProductDto findById(@PathVariable String id) {
		return sellerProductService.findById(id);
	}
	
	@PostMapping
	public ProductDto create(@RequestBody ProductDto dto) {
		return sellerProductService.create(dto);
	}
	
	@PutMapping("{id}")
	public ProductDto update(@PathVariable String id,@RequestBody ProductDto dto) {
		System.out.println("복사된 Productdto 정보오오오" + dto);
		return sellerProductService.update(id, dto);
	}
	
	@PutMapping("{id}/stock")
	public ProductDto updateStock(@PathVariable String id,@RequestBody  ProductDto dto) {
		return sellerProductService.updateStock(id, dto.getStock());
	}
	
	@GetMapping("{id}/test")
	public void test(@PathVariable String id) {
		productService.test(id);
	}
	
}
