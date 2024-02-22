package com.newpla.vm.domain.insertedcash.manager;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.newpla.vm.domain.insertedcash.entity.InsertedCash;

@Component
public class InsertedCashManagerImpl implements InsertedCashManager {

	@Autowired
	InsertedCashRepo repo;
	
	@Override
	public Optional<InsertedCash> findOne() {
		
		List<InsertedCash> insertedCashes = repo.findAll();
		
		if (CollectionUtils.isEmpty(insertedCashes)) {
			return Optional.empty();
		}
		return Optional.of(insertedCashes.get(0));
	}

	@Override
	public InsertedCash save(InsertedCash insertedCash) {
		return repo.save(insertedCash);
	}

}
