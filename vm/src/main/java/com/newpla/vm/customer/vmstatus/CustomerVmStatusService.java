package com.newpla.vm.customer.vmstatus;

import org.springframework.transaction.annotation.Transactional;

public interface CustomerVmStatusService {

	@Transactional
	public VmStatusDto showVmStatus();
}
