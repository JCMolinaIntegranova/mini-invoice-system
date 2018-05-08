package com.integranova.spring.miniinvoicesystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.integranova.spring.miniinvoicesystem.entity.oid.InvoiceLineOid;

@Entity(name = "InvoiceLine")
@Table(name = "invoiceline")
@IdClass(InvoiceLineOid.class)
public class InvoiceLine {

	@Id
	@Column(name = "invoiceid", insertable = false, updatable = false)
	private Long invoiceId;

	@Id
	@Column(name = "lineid")
	private Long lineId;

    @Column(name = "linedescription")
    @Size(max=150)
    @NotNull
    private String lineDescription;

    @Column(name = "lineqty")
    @NotNull
    private Long lineQty;

    @Column(name = "lineunitprice")
    @NotNull
    private Double lineUnitPrice;

	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "invoiceid", referencedColumnName = "invoiceid", insertable = false, updatable = false) })
	private Invoice invoice;

	public Double getLineTotal() {
		return lineTotalDerivations();
	}

	protected Double lineTotalDerivations() {
		return this.lineUnitPrice * this.lineQty;
	}

    public InvoiceLine() {
    }
    
	public InvoiceLine(Long invoiceId, Long lineId, String lineDescription, Long lineQty, Double lineUnitPrice) {
		this.invoiceId = invoiceId;
		this.lineId = lineId;
        this.lineDescription = lineDescription;
        this.lineQty = lineQty;
        this.lineUnitPrice = lineUnitPrice;
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

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public InvoiceLineOid getOid() {
		return new InvoiceLineOid(invoiceId, lineId);
	}

	@Override
	public String toString() {
		return String.format(
				"%nInvoiceLine [invoiceId=%s, lineId=%s, lineDescription=%s, lineQty=%s, lineUnitPrice=%s]", invoiceId,
				lineId,
				lineDescription, lineQty, lineUnitPrice);
	}

}
