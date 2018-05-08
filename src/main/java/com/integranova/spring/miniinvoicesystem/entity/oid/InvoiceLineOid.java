package com.integranova.spring.miniinvoicesystem.entity.oid;

import java.io.Serializable;


public class InvoiceLineOid implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long invoiceId;

	private Long lineId;

	public InvoiceLineOid() {

	}

	public InvoiceLineOid(Long invoiceId, Long lineId) {
		this.invoiceId = invoiceId;
		this.lineId = lineId;
	}

	public Long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Long getLineId() {
		return lineId;
	}

	public void setLineId(Long lineId) {
		this.lineId = lineId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((invoiceId == null) ? 0 : invoiceId.hashCode());
		result = prime * result + ((lineId == null) ? 0 : lineId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceLineOid other = (InvoiceLineOid) obj;
		if (invoiceId == null) {
			if (other.invoiceId != null)
				return false;
		} else if (!invoiceId.equals(other.invoiceId))
			return false;
		if (lineId == null) {
			if (other.lineId != null)
				return false;
		} else if (!lineId.equals(other.lineId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("InvoiceLineOid [invoiceId=%s, lineId=%s]", invoiceId, lineId);
	}

}
