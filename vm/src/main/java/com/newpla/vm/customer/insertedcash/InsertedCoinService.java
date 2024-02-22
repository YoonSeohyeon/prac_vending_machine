package com.newpla.vm.customer.insertedcash;

import org.springframework.transaction.annotation.Transactional;

public interface InsertedCoinService {

	@Transactional
	public void insert(InsertCoinDto dto);
	
	@Transactional
	public void withdraw(InsertCoinDto dto);
	
	@Transactional
	public long withdrawAll();
}
