package com.newpla.vm.core.insertedcash;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.newpla.vm.domain.insertedcash.entity.InsertedCash;
import com.newpla.vm.domain.insertedcash.manager.InsertedCashManager;

@Service
public class InsertedCashServiceImpl implements InsertedCashService {

	@Autowired
	InsertedCashManager insertedCashManager;
	@Override
	public InsertedCash findOne() {
		
		Optional<InsertedCash> insertedCash = insertedCashManager.findOne();
		
		if (insertedCash.isEmpty()) {
			InsertedCash initInsertedCash = new InsertedCash();
			
			initInsertedCash.setId(null);
			initInsertedCash.setPrice(0);
			initInsertedCash.setUpdatedAt(LocalDateTime.now());
			
			InsertedCash savedInsertedCash = insertedCashManager.save(initInsertedCash);
			
			return savedInsertedCash;
		}
		
		return insertedCash.get();
	}

	@Override
	public InsertedCash save(InsertedCash insertedCash) {
		
		Assert.notNull(insertedCash, "insertedCash is not null");
		Assert.hasText(insertedCash.getId(), "id is required");
		insertedCash.setUpdatedAt(LocalDateTime.now());
		return insertedCashManager.save(insertedCash);
	}

}
