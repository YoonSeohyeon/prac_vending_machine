package com.newpla.vm.customer.insertedcash;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.newpla.vm.core.insertedcash.InsertedCashService;
import com.newpla.vm.domain.insertedcash.entity.InsertedCash;

@Service
public class InsertedCoinServiceImpl implements InsertedCoinService {

	private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

	@Autowired
	InsertedCashService insertedCashService;

	@Override
	public void insert(InsertCoinDto dto) {

		log.info("inserteCoin : " + dto.getPrice());
		Assert.isTrue(dto.getPrice() > 0, "price is required and price must be positive");

		InsertedCash insertedCash = insertedCashService.findOne();

		insertedCash.setPrice(insertedCash.getPrice() + dto.getPrice());

		insertedCashService.save(insertedCash);
	}

	@Override
	public void withdraw(InsertCoinDto dto) {

		Assert.notNull(dto, "dto is required");

		log.info("used Coin : " + dto.getPrice());

		InsertedCash insertedCash = insertedCashService.findOne();

		Assert.isTrue(insertedCash.getPrice() > 0, "insertedCash is empty");

		Assert.isTrue(insertedCash.getPrice() >= dto.getPrice(), "insertedCash is not enough");

		insertedCash.setPrice(insertedCash.getPrice() - dto.getPrice());

		insertedCashService.save(insertedCash);

	}

	@Override
	public long withdrawAll() {

		InsertedCash insertedCash = insertedCashService.findOne();

		Assert.isTrue(insertedCash.getPrice() >= 0, "insertedCash is empty");

		long temp = insertedCash.getPrice();
		insertedCash.setPrice(0);

		insertedCashService.save(insertedCash);

		return temp;
	}

}
