package com.integranova.spring.miniinvoicesystem.viewmodel.customer.siu;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.integranova.spring.miniinvoicesystem.entity.oid.CustomerOid;

public class DeleteInstanceRequest {

	@JsonAlias("p_thisCustomer")
	private CustomerOid pThisCustomer;

	public DeleteInstanceRequest(CustomerOid pThisCustomer) {
		super();
		this.pThisCustomer = pThisCustomer;
	}

	public CustomerOid getpThisCustomer() {
		return pThisCustomer;
	}

	public void setpThisCustomer(CustomerOid pThisCustomer) {
		this.pThisCustomer = pThisCustomer;
	}
}
