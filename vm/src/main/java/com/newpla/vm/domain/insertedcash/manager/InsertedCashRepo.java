package com.newpla.vm.domain.insertedcash.manager;

import org.springframework.data.jpa.repository.JpaRepository;

import com.newpla.vm.domain.insertedcash.entity.InsertedCash;

public interface InsertedCashRepo extends JpaRepository<InsertedCash, String> {

}
