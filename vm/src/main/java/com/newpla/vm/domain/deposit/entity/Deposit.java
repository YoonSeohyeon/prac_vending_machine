package com.newpla.vm.domain.deposit.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.Comment;
import org.hibernate.annotations.GenericGenerator;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Data
@Entity
@Table(name = "vm_deposit")
@Comment("예치금")
public class Deposit {

	/**
	 * 식별자
	 */
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(nullable = false, length = 32)
	@Comment("id")
	private String id;

	/**
	 * 잔액
	 */
	@Comment("잔액")
	private long price;

	private LocalDateTime updatedAt;
	
}
