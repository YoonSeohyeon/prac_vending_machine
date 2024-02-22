package com.newpla.vm.customer.vmstatus;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.newpla.vm.core.insertedcash.InsertedCashService;
import com.newpla.vm.core.product.ProductService;
import com.newpla.vm.domain.insertedcash.entity.InsertedCash;
import com.newpla.vm.domain.product.entity.Product;

@Service
public class CustomerVmStatusServiceImpl implements CustomerVmStatusService {

	private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

	@Autowired
	ProductService productService;
	@Autowired
	InsertedCashService insertedCashService;

	@Override
	public VmStatusDto showVmStatus() {

		List<Product> productList = productService.findByEnable();
		InsertedCash insertedCash = insertedCashService.findOne();

		long currInsertedCash = insertedCash.getPrice();

		List<VmProductDto> productDisplayInfo = Lists.newArrayList();

		for (Product p : productList) {
			VmProductDto dto = new VmProductDto();
			BeanUtils.copyProperties(p, dto);

			dto.setSoldout(false);
			dto.setCanPurchase(false);

			if (p.getStock() < 1) {
				log.info("매진상태");
				dto.setSoldout(true);
			}

			if ((dto.isSoldout() == false) && (dto.getPrice() <= currInsertedCash)) {
				log.info("구매가능");
				dto.setCanPurchase(true);
			}

			productDisplayInfo.add(dto);
		}

		VmStatusDto vmDisplayInfo = new VmStatusDto();

		vmDisplayInfo.setInsertedCoin(currInsertedCash);
		vmDisplayInfo.setProductList(productDisplayInfo);

		log.info("VM - current inserted coin : " + vmDisplayInfo.getInsertedCoin());
		log.info("VM - currnet product Info : " + vmDisplayInfo.getProductList());

		return vmDisplayInfo;
	}

}
