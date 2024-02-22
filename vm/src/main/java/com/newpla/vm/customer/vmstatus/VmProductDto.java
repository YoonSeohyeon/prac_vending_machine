package com.newpla.vm.customer.vmstatus;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Data
public class VmProductDto {

	@EqualsAndHashCode.Include
	private String id;
	private String name;
	private long price;
	private boolean soldout;
	private boolean canPurchase;
	private boolean disabled;
}
