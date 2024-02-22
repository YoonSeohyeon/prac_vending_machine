package com.newpla.vm.seller.deposit;

public enum DepositActionType {

	INSERT("insert"), WITHDRAW("withdraw");
	
	private String name;
	
	DepositActionType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
