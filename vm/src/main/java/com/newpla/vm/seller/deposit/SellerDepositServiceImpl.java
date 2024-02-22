package com.newpla.vm.seller.deposit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.newpla.vm.core.deposit.DepositService;
import com.newpla.vm.domain.deposit.entity.Deposit;

@Service
public class SellerDepositServiceImpl implements SellerDepositService {

	private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

	@Autowired
	DepositService depositService;

	@Override
	public DepositDto currentDeposit() {

		Deposit deposit = depositService.findOne();

		DepositDto dto = new DepositDto();

//		dto.setPrice(deposit.getPrice());
		BeanUtils.copyProperties(deposit, dto);

		return dto;
	}

	@Override
	public DepositDto updateDeposit(DepositActionType depositActionType, long price) {


		Deposit deposit = depositService.findOne();

		if (depositActionType == DepositActionType.WITHDRAW) {
			Assert.isTrue(deposit.getPrice() >= price, "deposit is not enough to withdraw");
			deposit.setPrice(deposit.getPrice() - price);
		} else {
			deposit.setPrice(deposit.getPrice() + price);
		}

		depositService.save(deposit);

		DepositDto dto = new DepositDto();

		BeanUtils.copyProperties(deposit, dto);

		return dto;
	}

}
