package com.newpla.vm.core.deposit;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.newpla.vm.domain.deposit.entity.Deposit;
import com.newpla.vm.domain.deposit.manager.DepositManager;

@Service
public class DepositServiceImpl implements DepositService {

	@Autowired
	DepositManager depositManager;
	
	@Override
	public Deposit findOne() {
		
		Optional<Deposit> deposit = depositManager.findOne();
		
		if (deposit.isEmpty()) {
			
			Deposit initDeposit = new Deposit();
			
			initDeposit.setId(null);
			initDeposit.setPrice(0);
			initDeposit.setUpdatedAt(LocalDateTime.now());
			
			Deposit savedDeposit = depositManager.save(initDeposit);
			
			return savedDeposit;
		}
		return deposit.get();
	}

	@Override
	public Deposit save(Deposit deposit) {

		Assert.notNull(deposit, "deposit is not null");
		Assert.hasText(deposit.getId(), "id is required");
		deposit.setUpdatedAt(LocalDateTime.now());
		return depositManager.save(deposit);
	}

}
