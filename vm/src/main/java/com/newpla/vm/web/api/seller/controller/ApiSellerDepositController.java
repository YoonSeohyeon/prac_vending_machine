package com.newpla.vm.web.api.seller.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.newpla.vm.seller.deposit.DepositActionType;
import com.newpla.vm.seller.deposit.DepositDto;
import com.newpla.vm.seller.deposit.SellerDepositService;

@RestController
@RequestMapping("/api/seller/deposit")
public class ApiSellerDepositController {

	@Autowired
	SellerDepositService sellerDepositService;
	
	@GetMapping
	public DepositDto currentDeposit() {
		return sellerDepositService.currentDeposit();
	}
	
	@PostMapping("{depositActonType}")
	public DepositDto updateDeposit(@PathVariable DepositActionType depositActonType,@RequestBody DepositDto data) {
		long price = data.getPrice();
		return sellerDepositService.updateDeposit(depositActonType, price);
	}
}
