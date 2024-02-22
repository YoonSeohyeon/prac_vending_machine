package com.newpla.vm.seller.product;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.google.common.collect.Lists;
import com.newpla.vm.core.product.ProductService;
import com.newpla.vm.domain.product.entity.Product;

@Service
public class SellerProductServiceImpl implements SellerProductService {

	private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

	@Autowired
	ProductService productService;

	@Override
	public List<ProductDto> findAll() {

		List<Product> products = productService.findAll();

		List<ProductDto> productsResult = Lists.newArrayList();

		for (Product p : products) {
			ProductDto dto = new ProductDto();
			BeanUtils.copyProperties(p, dto);
			productsResult.add(dto);
		}

		return productsResult;
	}

	@Override
	public ProductDto findById(String id) {

		Assert.hasText(id, "id is required");

		log.info("seller product findbyid - ID : " + id);

		Product product = productService.findById(id);

		ProductDto dto = new ProductDto();
		BeanUtils.copyProperties(product, dto);

		return dto;
	}

	@Override
	public ProductDto create(ProductDto dto) {

		Assert.notNull(dto, "dto is required");
		Assert.isTrue(StringUtils.hasText(dto.getId()) == false, "id must be null");
		Assert.hasText(dto.getName(), "name is required");

		log.info("seller Create Product dto : " + dto.getName());

		dto.setId(null);
		dto.setStock(0);

		Product product = new Product();
		BeanUtils.copyProperties(dto, product);

		Product result = productService.create(product);

		ProductDto productDto = new ProductDto();
		BeanUtils.copyProperties(result, productDto);

		return productDto;

	}

	@Override
	public ProductDto update(String id, ProductDto dto) {

		Assert.notNull(dto, "product must be not null");
		System.out.println("복사된 Product 정보오오오" + dto);
		Assert.hasText(id, "id is required");
		Assert.hasText(dto.getName(), "name is required");

		log.info("seller Update Product dto : " + dto);

		Product product = productService.findById(id);

		// id, stock만 제외하고 dto를 product에 복사
		BeanUtils.copyProperties(dto, product, "id","stock");

		Product updateProduct = productService.update(product);

		ProductDto result = new ProductDto();
		BeanUtils.copyProperties(updateProduct, result);

		return result;
	}

	@Override
	public ProductDto updateStock(String id, int stock) {

		Assert.hasText(id, "id is required");

		log.info("seller UpdateStock id : " + id + "stock : " + stock);

		Product product = productService.findById(id);

		product.setStock(stock);

		Product results = productService.update(product);

		ProductDto resultDto = new ProductDto();
		BeanUtils.copyProperties(results, resultDto);

		return resultDto;
	}

}
