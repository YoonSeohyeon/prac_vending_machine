package com.newpla.vm.customer.purchase;

import org.springframework.transaction.annotation.Transactional;

public interface CustomerPurchaseService {

	@Transactional
	public void purchase(PurchaseDto dto);
	
}
