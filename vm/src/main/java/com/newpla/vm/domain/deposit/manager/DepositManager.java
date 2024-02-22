package com.newpla.vm.domain.deposit.manager;

import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.newpla.vm.domain.deposit.entity.Deposit;

public interface DepositManager {

	@Transactional(readOnly = true)
	Optional<Deposit> findOne();
	
	@Transactional
	Deposit save(Deposit deposit);
	
}
