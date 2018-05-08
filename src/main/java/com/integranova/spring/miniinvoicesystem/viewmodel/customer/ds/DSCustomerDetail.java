package com.integranova.spring.miniinvoicesystem.viewmodel.customer.ds;

import com.integranova.spring.miniinvoicesystem.entity.Customer;

public class DSCustomerDetail {


	private String customerName;

	private String customerEmail;

	public DSCustomerDetail() {

	}

	public DSCustomerDetail(Customer instance) {
		this.customerName = instance.getCustomerName();
		this.customerEmail = instance.getCustomerEmail();
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
