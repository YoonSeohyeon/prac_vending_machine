package com.newpla.vm.domain.product.entity;

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
@Entity
@Data
@Table (name = "vm_product")
@Comment("상품")
public class Product {

	/**
	 * 식별자
	 */
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "product_id", nullable = false, length = 32)
	@Comment("id")
	private String id;
	
	/**
	 * 순번
	 */
	@Column(nullable = false, columnDefinition = "INT default 0")
	@Comment("순번")
	private int seq;
	
	/**
	 * 상품이름
	 */
	@Column(nullable = false, length = 100)
	@Comment("상품 이름")
	private String name;
	
	/**
	 * 가격
	 */
	@Comment("상품 가격")
	private long price;

	/**
	 * 판매유무
	 */
	@Column(nullable = false, columnDefinition = "BIT default false")
	@Comment("판매유무")
	private boolean disabled;

	/**
	 * 재고
	 */
	@Column(nullable = false, columnDefinition = "INT default 0")
	@Comment("상품 재고")
	private int stock;
	
	private LocalDateTime updatedAt;
	
}
