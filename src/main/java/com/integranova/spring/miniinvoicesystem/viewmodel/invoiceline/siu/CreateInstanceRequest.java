package com.integranova.spring.miniinvoicesystem.viewmodel.invoiceline.siu;

import com.integranova.spring.miniinvoicesystem.entity.oid.InvoiceOid;

public class CreateInstanceRequest {

	private InvoiceOid pAgrInvoice;

	private Long pAtrLineId;

	private String pAtrLineDescription;

	private Long pAtrLineQty;

	private Double pAtrLineUnitPrice;


	public CreateInstanceRequest() {
		super();
	}

	public CreateInstanceRequest(InvoiceOid pAgrInvoice, Long pAtrLineId, String pAtrLineDescription, Long pAtrLineQty,
			Double pAtrLineUnitPrice) {
		super();
		this.pAgrInvoice = pAgrInvoice;
		this.pAtrLineId = pAtrLineId;
		this.pAtrLineDescription = pAtrLineDescription;
		this.pAtrLineQty = pAtrLineQty;
		this.pAtrLineUnitPrice = pAtrLineUnitPrice;
	}

	public InvoiceOid getpAgrInvoice() {
		return pAgrInvoice;
	}

	public void setpAgrInvoice(InvoiceOid pAgrInvoice) {
		this.pAgrInvoice = pAgrInvoice;
	}

	public Long getpAtrLineId() {
		return pAtrLineId;
	}

	public void setpAtrLineId(Long pAtrLineId) {
		this.pAtrLineId = pAtrLineId;
	}

	public String getpAtrLineDescription() {
		return pAtrLineDescription;
	}

	public void setpAtrLineDescription(String pAtrLineDescription) {
		this.pAtrLineDescription = pAtrLineDescription;
	}

	public Long getpAtrLineQty() {
		return pAtrLineQty;
	}

	public void setpAtrLineQty(Long pAtrLineQty) {
		this.pAtrLineQty = pAtrLineQty;
	}

	public Double getpAtrLineUnitPrice() {
		return pAtrLineUnitPrice;
	}

	public void setpAtrLineUnitPrice(Double pAtrLineUnitPrice) {
		this.pAtrLineUnitPrice = pAtrLineUnitPrice;
	}
}