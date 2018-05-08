package com.integranova.spring.miniinvoicesystem.viewmodel.customer.ds;

import com.integranova.spring.miniinvoicesystem.entity.Customer;

public class DSCustomers {

	private Long customerId;

	private String customerName;

	private String customerEmail;

	public DSCustomers() {

	}

	public DSCustomers(Customer instance) {
		this.customerId = instance.getOid().getCustomerId();
		this.customerName = instance.getCustomerName();
		this.customerEmail = instance.getCustomerEmail();
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

}
