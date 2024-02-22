package com.newpla.vm.domain.q;

import com.newpla.vm.domain.deposit.entity.QDeposit;
import com.newpla.vm.domain.insertedcash.entity.QInsertedCash;
import com.newpla.vm.domain.product.entity.QProduct;

public class Q {

	public static final QProduct product = QProduct.product;

	public static final QDeposit deposit = QDeposit.deposit;

	public static final QInsertedCash insertedCash = QInsertedCash.insertedCash;
}
