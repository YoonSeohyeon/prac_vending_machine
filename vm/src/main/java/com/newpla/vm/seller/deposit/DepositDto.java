package com.newpla.vm.seller.deposit;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class DepositDto {

	private long price;
	private LocalDateTime updatedAt;
}
