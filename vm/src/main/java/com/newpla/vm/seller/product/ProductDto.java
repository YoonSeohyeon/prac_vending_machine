package com.newpla.vm.seller.product;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Data
public class ProductDto {

	@EqualsAndHashCode.Include
	private String id;
	private int seq;
	private String name;
	private long price;
	private boolean disabled;
	private int stock;
}
