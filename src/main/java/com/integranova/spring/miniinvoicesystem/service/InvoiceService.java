package com.integranova.spring.miniinvoicesystem.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.integranova.spring.miniinvoicesystem.entity.Customer;
import com.integranova.spring.miniinvoicesystem.entity.Invoice;
import com.integranova.spring.miniinvoicesystem.entity.InvoiceLine;
import com.integranova.spring.miniinvoicesystem.entity.oid.InvoiceOid;
import com.integranova.spring.miniinvoicesystem.exception.ModelException;
import com.integranova.spring.miniinvoicesystem.repository.InvoiceJpaRepository;

@Service
@Transactional
public class InvoiceService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private InvoiceJpaRepository repository;

	@Autowired
	private InvoiceLineService invoiceLineService;

	public Invoice find(Long invoiceId) {
		return find(new InvoiceOid(invoiceId));
	}

	public Invoice find(InvoiceOid oid) {
		Optional<Invoice> instance = repository.findById(oid);
		return instance.isPresent() ? instance.get() : null;
	}

	public List<Invoice> findByCustomer(Customer customer) {
		return repository.findByCustomerId(customer.getCustomerId());
	}

	public List<Invoice> findByCustomerName(String customerName) {
		return repository.findByCustomerCustomerName(customerName);
	}

	public Invoice create(Invoice invoice) {
		invoice.getCustomer().getInvoices().add(invoice);
		return repository.save(invoice);
	}

	public Invoice update(Invoice invoice) {
		return updateImplementation(invoice);
	}

	public Invoice updateImplementation(Invoice invoice) {
		return repository.save(invoice);
	}

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
			ModelException.class })
	public Invoice updateAll(Invoice invoice) throws ModelException {
		return updateAllImplementation(invoice);
	}

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.SUPPORTS)
	public Invoice updateAllImplementation(Invoice invoice) throws ModelException {
		for (InvoiceLine item : invoice.getLines()) {
			item.setLineQty(item.getLineQty() * 10);
			invoiceLineService.updateImplementation(item);
		}
		return updateImplementation(invoice);
	}

	public void delete(Long invoiceId) {
		delete(new InvoiceOid(invoiceId));
	}

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRES_NEW)
	public void delete(InvoiceOid oid) {
		deleteImplementation(find(oid));
	}

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.SUPPORTS)
	public void deleteImplementation(Invoice invoice) {
		repository.delete(invoice);
	}

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRES_NEW)
	public void deleteAll(Invoice invoice) {
		try {
			deleteAllImplementation(invoice);
		} catch (ModelException e) {
			logger.error(e.getMessage());
		}
	}

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.SUPPORTS)
	public void deleteAllImplementation(Invoice invoice) throws ModelException {

		Collection<InvoiceLine> itemsToDelete = invoice.getLines();
		for (InvoiceLine item : itemsToDelete) {
			invoiceLineService.deleteImplementation(item);
		}

		deleteImplementation(invoice);
	}

	public void deleteAll() {
		repository.deleteAllInBatch();
	}
}
