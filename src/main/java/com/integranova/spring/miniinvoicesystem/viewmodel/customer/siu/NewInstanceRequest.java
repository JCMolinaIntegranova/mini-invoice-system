package com.integranova.spring.miniinvoicesystem.viewmodel.customer.siu;

public class NewInstanceRequest {

	private String pAtrcustomerName;

	private String pAtrCustomerEmail;

	public NewInstanceRequest(String pAtrcustomerName, String pAtrCustomerEmail) {
		super();
		this.pAtrcustomerName = pAtrcustomerName;
		this.pAtrCustomerEmail = pAtrCustomerEmail;
	}

	public String getpAtrcustomerName() {
		return pAtrcustomerName;
	}

	public void setpAtrcustomerName(String pAtrcustomerName) {
		this.pAtrcustomerName = pAtrcustomerName;
	}

	public String getpAtrCustomerEmail() {
		return pAtrCustomerEmail;
	}

	public void setpAtrCustomerEmail(String pAtrCustomerEmail) {
		this.pAtrCustomerEmail = pAtrCustomerEmail;
	}
}
