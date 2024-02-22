package com.newpla.vm.domain.deposit.manager;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.newpla.vm.domain.deposit.entity.Deposit;

@Component
public class DepositManagerImpl implements DepositManager {

	@Autowired
	DepositRepo repo;
	
	@Override
	public Optional<Deposit> findOne() {

		List<Deposit> deposits = repo.findAll();
		
		if (CollectionUtils.isEmpty(deposits)) {
			return Optional.empty();
		}
		
		return Optional.of(deposits.get(0));
	}

	@Override
	public Deposit save(Deposit deposit) {
		return repo.save(deposit);
	}

}
