package com.newpla.vm.domain.insertedcash.manager;

import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.newpla.vm.domain.insertedcash.entity.InsertedCash;

public interface InsertedCashManager {

	@Transactional(readOnly = true)
	Optional<InsertedCash> findOne();
	
	@Transactional
	InsertedCash save(InsertedCash insertedCash);
}
