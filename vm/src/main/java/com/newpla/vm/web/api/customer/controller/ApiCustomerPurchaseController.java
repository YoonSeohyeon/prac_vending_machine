package com.newpla.vm.web.api.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newpla.vm.customer.purchase.CustomerPurchaseService;
import com.newpla.vm.customer.purchase.PurchaseDto;

@RestController
@RequestMapping("/api/customer/purchase")
public class ApiCustomerPurchaseController {

	@Autowired
	CustomerPurchaseService customerPurchaseService;
	
	@PostMapping
	public void purchase(@RequestBody PurchaseDto dto) {
		customerPurchaseService.purchase(dto);
	}
}
