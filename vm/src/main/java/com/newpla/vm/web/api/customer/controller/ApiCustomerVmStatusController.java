package com.newpla.vm.web.api.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newpla.vm.customer.vmstatus.CustomerVmStatusService;
import com.newpla.vm.customer.vmstatus.VmStatusDto;

@RestController
@RequestMapping("/api/customer/vm/status")
public class ApiCustomerVmStatusController {

	@Autowired
	CustomerVmStatusService customerDisplayInfoService;
	
	@GetMapping
	public VmStatusDto showVmStatus() {
		return customerDisplayInfoService.showVmStatus();
	}
}
