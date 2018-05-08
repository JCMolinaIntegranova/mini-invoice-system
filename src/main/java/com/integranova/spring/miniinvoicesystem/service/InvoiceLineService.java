package com.integranova.spring.miniinvoicesystem.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.integranova.spring.miniinvoicesystem.entity.Invoice;
import com.integranova.spring.miniinvoicesystem.entity.InvoiceLine;
import com.integranova.spring.miniinvoicesystem.entity.oid.InvoiceLineOid;
import com.integranova.spring.miniinvoicesystem.exception.ModelException;
import com.integranova.spring.miniinvoicesystem.repository.InvoiceLineJpaRepository;
import com.integranova.spring.miniinvoicesystem.viewmodel.invoiceline.ds.DSInvoiceLine;

@Service
@Transactional
public class InvoiceLineService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	InvoiceLineJpaRepository repository;

	public InvoiceLine find(Long invoiceId, Long lineId) {
		return find(new InvoiceLineOid(invoiceId, lineId));
	}

	public InvoiceLine find(InvoiceLineOid oid) {
		Optional<InvoiceLine> instance = repository.findById(oid);
		return instance.isPresent() ? instance.get() : null;
	}

	public List<InvoiceLine> findByInvoice(Invoice invoice) {
		return repository.findByInvoiceId(invoice.getInvoiceId());
	}

	public InvoiceLine create(InvoiceLine instance) {
		instance.getInvoice().getLines().add(instance);
		return repository.save(instance);
	}

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
			ModelException.class })
	public InvoiceLine update(InvoiceLine instance) throws ModelException {
		return updateImplementation(instance);
	}

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.SUPPORTS)
	public InvoiceLine updateImplementation(InvoiceLine instance) throws ModelException {
		if (instance.getOid().getInvoiceId().equals(2L) && instance.getOid().getLineId().equals(2L))
			throw new ModelException("Cannot edit line 2 2");
		return repository.save(instance);
	}

	public void delete(Long invoiceId, Long lineId) {
		delete(new InvoiceLineOid(invoiceId, lineId));
	}

	public void delete(InvoiceLineOid oid) {
		delete(find(oid));
	}

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRES_NEW)
	public void delete(InvoiceLine instance) {
		try {
			deleteImplementation(instance);
		} catch (ModelException e) {
			logger.error("{}", e.getMessage());
		}
	}

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.SUPPORTS)
	public void deleteImplementation(InvoiceLine instance) throws ModelException {
		if (instance.getLineDescription().equals("FAIL"))
			throw new ModelException("Something went very wrong");
		instance.getInvoice().getLines().remove(instance);
		repository.delete(instance);
	}

	public void deleteAll() {
		repository.deleteAllInBatch();
	}

	public List<DSInvoiceLine> piuInvoiceLines() {
		return repository.findAll().stream().map(DSInvoiceLine::new).collect(Collectors.toList());
	}
}
