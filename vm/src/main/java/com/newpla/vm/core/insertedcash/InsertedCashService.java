package com.newpla.vm.core.insertedcash;


import org.springframework.transaction.annotation.Transactional;

import com.newpla.vm.domain.insertedcash.entity.InsertedCash;

public interface InsertedCashService {

	@Transactional
	public InsertedCash findOne();
	
	@Transactional
	public InsertedCash save(InsertedCash insertedCash);
}
