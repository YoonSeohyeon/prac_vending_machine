package com.newpla.vm.seller.deposit;

import org.springframework.transaction.annotation.Transactional;

public interface SellerDepositService {
	
	@Transactional
	public DepositDto currentDeposit();
	
	/**
	 * @param depositActionType 
	 * depositActionType은 WITHDRAW와 INSERT
	 * @param price
	 * @return
	 */
	@Transactional
	public DepositDto updateDeposit(DepositActionType depositActionType, long price);
}
