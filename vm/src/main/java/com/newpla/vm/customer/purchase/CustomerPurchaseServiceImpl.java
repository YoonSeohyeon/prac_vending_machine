package com.newpla.vm.customer.purchase;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import com.newpla.vm.core.deposit.DepositService;
import com.newpla.vm.core.product.ProductService;
import com.newpla.vm.customer.insertedcash.InsertCoinDto;
import com.newpla.vm.customer.insertedcash.InsertedCoinService;
import com.newpla.vm.customer.vmstatus.CustomerVmStatusService;
import com.newpla.vm.customer.vmstatus.VmProductDto;
import com.newpla.vm.customer.vmstatus.VmStatusDto;
import com.newpla.vm.domain.deposit.entity.Deposit;
import com.newpla.vm.domain.product.entity.Product;

@Service
public class CustomerPurchaseServiceImpl implements CustomerPurchaseService {

	private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

	@Autowired
	ProductService productService;
	@Autowired
	DepositService depositService;
	@Autowired
	CustomerVmStatusService customerVmStatusService;
	@Autowired
	InsertedCoinService insertedCoinService;

	@Override
	public void purchase(PurchaseDto dto) {

		Assert.notNull(dto, "dto is required");

		log.info("sellectedProduct : " + dto);

		// 자판기에 표시된 정보 조회 (상품 리스트, 투입금액)
		VmStatusDto vmDisplayInfoDto = customerVmStatusService.showVmStatus();

		List<VmProductDto> products = vmDisplayInfoDto.getProductList();

		// 선택한 상품이 상품 리스트에 있는지 조회

		VmProductDto selectedProduct = products.stream()
				//
				.filter(o -> o.getId()
						//
						.equals(dto.getSelectedProductId()))
				.findFirst().orElse(null);

		Assert.notNull(selectedProduct, "correct product dto is required");

		// 상태조회 (매진, 구매가능, 판매여부)
		Assert.isTrue(selectedProduct.isDisabled() == false, "this product is disabled");
		Assert.isTrue(selectedProduct.isSoldout() == false, "this product is soldOut!");
		Assert.isTrue(selectedProduct.isCanPurchase(), "Not enough money!");

		// 투입금액 차감
		InsertCoinDto insertCoin = new InsertCoinDto();
		insertCoin.setPrice(selectedProduct.getPrice());
		insertedCoinService.withdraw(insertCoin);

		// 잔액 추가
		Deposit deposit = depositService.findOne();
		deposit.setPrice(deposit.getPrice() + selectedProduct.getPrice());
		depositService.save(deposit);

		// 재고 차감
		Product product = productService.findById(selectedProduct.getId());

		Assert.isTrue(product.getStock() > 0, "SOLD OUT!");

		product.setStock(product.getStock() - 1);

		productService.update(product);

	}

}
