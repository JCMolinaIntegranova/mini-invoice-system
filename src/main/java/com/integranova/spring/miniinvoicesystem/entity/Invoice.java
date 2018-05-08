package com.integranova.spring.miniinvoicesystem.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.integranova.spring.miniinvoicesystem.entity.oid.InvoiceOid;
import com.integranova.spring.miniinvoicesystem.service.CustomerService;
import com.integranova.spring.miniinvoicesystem.service.InvoiceLineService;

@Entity(name = "Invoice")
@Table(name = "invoice")
@IdClass(InvoiceOid.class)
public class Invoice implements ApplicationContextAware {

	@Transient
	private CustomerService customerService;
	@Transient
	private InvoiceLineService invoiceLineService;

	@Column(name = "invoiceid")
	@NotNull
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long invoiceId;

    @Column(name = "customerid")
    @NotNull
    private Long customerId;

    @Column(name = "invoicedate")
    @NotNull
    private Date invoiceDate;

    @Column(name = "invoicenotes")
    private String invoiceNotes;

	@OneToMany(mappedBy = "invoice")
	private Collection<InvoiceLine> lines;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "customerid", referencedColumnName = "customerid", insertable = false, updatable = false) })
	private Customer customer;

    public Invoice() {
    }
    
	public Invoice(Long invoiceId, Long customerId, Date invoiceDate, String invoiceNotes) {
		this.invoiceId = invoiceId;
        this.customerId = customerId;
        this.invoiceDate = invoiceDate;
        this.invoiceNotes = invoiceNotes;
		this.lines = new ArrayList<>();
    }

	public Long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getInvoiceNotes() {
		return invoiceNotes;
	}

	public void setInvoiceNotes(String invoiceNotes) {
		this.invoiceNotes = invoiceNotes;
	}

	public Collection<InvoiceLine> getLines() {
		if (lines == null || lines.isEmpty()) {
			lines = (invoiceLineService != null ? invoiceLineService.findByInvoice(this) : new ArrayList<>());
		}
		return lines;
	}

	public void setLines(Collection<InvoiceLine> lines) {
		this.lines = lines;
	}

	public Customer getCustomer() {
		if (customer == null) {
			customer = customerService.find(getCustomerId());
		}
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public InvoiceOid getOid() {
		return new InvoiceOid(invoiceId);
	}

	@Override
	public String toString() {
		return String.format(
				"%nInvoice [invoiceId=%s, customerId=%s, invoiceDate=%s, invoiceNotes=%s]", invoiceId, customerId,
				invoiceDate,
				invoiceNotes);
	}

	@Override
	public void setApplicationContext(ApplicationContext context) {
		customerService = context.getBean(CustomerService.class);
		invoiceLineService = context.getBean(InvoiceLineService.class);
	}
}
