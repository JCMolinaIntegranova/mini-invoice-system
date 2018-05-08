package com.integranova.spring.miniinvoicesystem.entity.oid;

import java.io.Serializable;

public class InvoiceOid implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long invoiceId;

	public InvoiceOid() {

	}

	public InvoiceOid(Long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((invoiceId == null) ? 0 : invoiceId.hashCode());
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
		InvoiceOid other = (InvoiceOid) obj;
		if (invoiceId == null) {
			if (other.invoiceId != null)
				return false;
		} else if (!invoiceId.equals(other.invoiceId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("InvoiceOid [invoiceId=%s]", invoiceId);
	}
}
