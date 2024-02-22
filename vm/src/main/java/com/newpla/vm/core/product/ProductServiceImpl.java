package com.newpla.vm.core.product;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.google.common.collect.Lists;
import com.newpla.vm.domain.product.entity.Product;
import com.newpla.vm.domain.product.manager.ProductManager;
import com.newpla.vm.domain.q.Q;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;

import jakarta.persistence.EntityManager;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductManager productManager;
	@Autowired
	EntityManager entityManager;

	@Override
	public List<Product> findAll() {

		return productManager.findOrderBySeq();
	}

	@Override
	public List<Product> findByEnable() {

		var q = Q.product;

		BooleanBuilder bb = new BooleanBuilder();
		bb.and(q.disabled.eq(false));

		JPAQuery<Product> query = new JPAQuery<>(entityManager);
		List<Product> list = query.from(q).where(bb).fetch();

		return list;
	}

	@Override
	public Product findById(String id) {

		Assert.hasText(id, "id is required");

		return productManager.findById(id).orElseThrow();
	}

	@Override
	public Product create(Product product) {

		Assert.notNull(product, "product is not null");
		Assert.isTrue(StringUtils.hasText(product.getId()) == false, "id is null");
		Assert.hasText(product.getName(), "name is required");

		product.setUpdatedAt(LocalDateTime.now());

		return productManager.save(product);
	}

	@Override
	public Product update(Product product) {

		Assert.notNull(product, "product is not null");
		Assert.hasText(product.getId(), "id is required");
		Assert.hasText(product.getName(), "name is required");

		product.setUpdatedAt(LocalDateTime.now());
		return productManager.save(product);
	}

	@Override
	public void test(String id) {
		Product p =productManager.findById(id).orElseThrow();
		p.setName("변경");
		
	}

}
