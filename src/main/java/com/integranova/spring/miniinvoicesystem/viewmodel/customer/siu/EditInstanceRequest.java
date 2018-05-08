package com.integranova.spring.miniinvoicesystem.viewmodel.customer.siu;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.integranova.spring.miniinvoicesystem.entity.oid.CustomerOid;

public class EditInstanceRequest {

	@JsonAlias("p_thisCustomer")
	private CustomerOid pThisCustomer;

	@JsonAlias("p_customerName")
	private String pCustomerName;

	@JsonAlias("p_customerEmail")
	private String pCustomerEmail;

	public EditInstanceRequest(CustomerOid pThisCustomer, String pCustomerName, String pCustomerEmail) {
		super();
		this.pThisCustomer = pThisCustomer;
		this.pCustomerName = pCustomerName;
		this.pCustomerEmail = pCustomerEmail;
	}

	public CustomerOid getpThisCustomer() {
		return pThisCustomer;
	}

	public void setpThisCustomer(CustomerOid pThisCustomer) {
		this.pThisCustomer = pThisCustomer;
	}

	public String getpCustomerName() {
		return pCustomerName;
	}

	public void setpCustomerName(String pCustomerName) {
		this.pCustomerName = pCustomerName;
	}

	public String getpCustomerEmail() {
		return pCustomerEmail;
	}

	public void setpCustomerEmail(String pCustomerEmail) {
		this.pCustomerEmail = pCustomerEmail;
	}

}
