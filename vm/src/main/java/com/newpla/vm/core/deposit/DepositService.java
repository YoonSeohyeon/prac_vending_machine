package com.newpla.vm.core.deposit;

import org.springframework.transaction.annotation.Transactional;

import com.newpla.vm.domain.deposit.entity.Deposit;

public interface DepositService {

	@Transactional
	public Deposit findOne();
	
	@Transactional
	public Deposit save(Deposit deposit);
}
