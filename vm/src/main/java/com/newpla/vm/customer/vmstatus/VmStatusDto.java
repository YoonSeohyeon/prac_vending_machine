package com.newpla.vm.customer.vmstatus;

import java.util.List;

import lombok.Data;

@Data
public class VmStatusDto {
	
	private List<VmProductDto> productList;
	
	private long insertedCoin;
}
