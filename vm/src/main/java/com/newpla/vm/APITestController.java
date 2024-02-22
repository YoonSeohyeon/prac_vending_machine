package com.newpla.vm;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newpla.vm.seller.product.ProductDto;

@RestController
@RequestMapping("/api/test")
public class APITestController {

	@GetMapping
	public ProductDto test() {
		ProductDto d = new ProductDto();
		return d;
	}
}
