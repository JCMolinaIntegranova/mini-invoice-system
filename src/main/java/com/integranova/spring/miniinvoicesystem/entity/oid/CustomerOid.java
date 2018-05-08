package com.integranova.spring.miniinvoicesystem.entity.oid;

import java.io.Serializable;

public class CustomerOid implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long customerId;

	public CustomerOid() {

	}

	public CustomerOid(Long customerId) {
		this.customerId = customerId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
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
		CustomerOid other = (CustomerOid) obj;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("CustomerOid [customerId=%s]", customerId);
	}

}
