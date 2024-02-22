package com.newpla.vm.domain.deposit.manager;

import org.springframework.data.jpa.repository.JpaRepository;

import com.newpla.vm.domain.deposit.entity.Deposit;

public interface DepositRepo extends JpaRepository<Deposit, String>{

}
