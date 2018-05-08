package com.integranova.spring.miniinvoicesystem.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.integranova.spring.miniinvoicesystem.entity.oid.CustomerOid;

@Entity(name = "Customer")
@Table(name = "customer")
@IdClass(CustomerOid.class)
public class Customer {

	@Column(name = "customerid")
	@NotNull
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long customerId;

    @Column(name = "customername")
    @Size(max=50)
    @NotNull
    private String customerName;

    @Column(name = "customeremail")
    @Size(max=100)
    private String customerEmail;

	@OneToMany(mappedBy = "customer")
	private Collection<Invoice> invoices;

    public Customer() {
    }
    
	public Customer(Long customerId, String customerName, String customerEmail) {
		this.customerId = customerId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
		this.invoices = new ArrayList<>();
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

	public Collection<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(Collection<Invoice> invoices) {
		this.invoices = invoices;
	}

	public CustomerOid getOid() {
		return new CustomerOid(customerId);
	}

	@Override
	public String toString() {
		return String.format("%nCustomer [customerId=%s, customerName=%s, customerEmail=%s]", customerId, customerName,
				customerEmail);
	}
}
