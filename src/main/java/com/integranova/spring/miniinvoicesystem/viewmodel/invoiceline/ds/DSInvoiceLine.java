package com.integranova.spring.miniinvoicesystem.viewmodel.invoiceline.ds;

import com.integranova.spring.miniinvoicesystem.entity.InvoiceLine;

public class DSInvoiceLine {

	private String lineDescription;

	private Long lineQty;

	private Double lineUnitPrice;

	private Double lineTotal;

	public DSInvoiceLine() {

	}

	public DSInvoiceLine(InvoiceLine instance) {
		lineDescription = instance.getLineDescription();
		lineQty = instance.getLineQty();
		lineUnitPrice = instance.getLineUnitPrice();
		lineTotal = instance.getLineTotal();
	}

	public String getLineDescription() {
		return lineDescription;
	}

	public void setLineDescription(String lineDescription) {
		this.lineDescription = lineDescription;
	}

	public Long getLineQty() {
		return lineQty;
	}

	public void setLineQty(Long lineQty) {
		this.lineQty = lineQty;
	}

	public Double getLineUnitPrice() {
		return lineUnitPrice;
	}

	public void setLineUnitPrice(Double lineUnitPrice) {
		this.lineUnitPrice = lineUnitPrice;
	}

	public Double getLineTotal() {
		return lineTotal;
	}

	public void setLineTotal(Double lineTotal) {
		this.lineTotal = lineTotal;
	}

}
