package com.newpla.vm.web.api.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newpla.vm.customer.insertedcash.InsertCoinDto;
import com.newpla.vm.customer.insertedcash.InsertedCoinService;

@RestController
@RequestMapping("/api/customer/insertCoin")
public class ApiCustomerInsertedCoinController {

	@Autowired
	InsertedCoinService insertedCoinService;
	
	@PostMapping("insert")
	public void insert(@RequestBody InsertCoinDto dto) {
		insertedCoinService.insert(dto);
	}
	
	@PostMapping("withdraw")
	public long withdrawAll() {
		return insertedCoinService.withdrawAll();
	}
}
