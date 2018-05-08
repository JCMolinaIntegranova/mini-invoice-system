package com.integranova.spring.miniinvoicesystem.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.integranova.spring.miniinvoicesystem.entity.Customer;
import com.integranova.spring.miniinvoicesystem.entity.Invoice;
import com.integranova.spring.miniinvoicesystem.entity.oid.CustomerOid;
import com.integranova.spring.miniinvoicesystem.exception.ModelException;
import com.integranova.spring.miniinvoicesystem.repository.CustomerJpaRepository;
import com.integranova.spring.miniinvoicesystem.viewmodel.customer.ds.DSCustomerDetail;
import com.integranova.spring.miniinvoicesystem.viewmodel.customer.ds.DSCustomers;

@Service
@Transactional
public class CustomerService {

	@Autowired
	private CustomerJpaRepository repository;

	@Autowired
	private InvoiceService invoiceService;

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public Customer find(Long customerId) {
		Optional<Customer> instance = repository.findById(new CustomerOid(customerId));
		return instance.isPresent() ? instance.get() : null;
	}

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public Customer find(CustomerOid oid) {
		return find(oid.getCustomerId());
	}

	public Customer newInstance(String pAtrcustomerName, String pAtrcustomerEmail) {
		return newInstanceTxn(pAtrcustomerName, pAtrcustomerEmail);
	}

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
			ModelException.class })
	public Customer newInstanceTxn(String pAtrcustomerName, String pAtrcustomerEmail) {
		return newInstanceImplementation(pAtrcustomerName, pAtrcustomerEmail);
	}

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.SUPPORTS)
	public Customer newInstanceImplementation(String pAtrcustomerName, String pAtrcustomerEmail) {
		Customer instance = new Customer();
		instance.setCustomerName(pAtrcustomerName);
		instance.setCustomerEmail(pAtrcustomerEmail);
		return repository.save(instance);
	}

	public Customer editInstance(CustomerOid pThisCustomer, String pCustomerName, String pCustomerEmail) {
		return editInstanceTxn(pThisCustomer, pCustomerName, pCustomerEmail);
	}

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
			ModelException.class })
	public Customer editInstanceTxn(CustomerOid pThisCustomerOid, String pCustomerName, String pCustomerEmail) {
		Customer pThisCustomer = this.find(pThisCustomerOid);
		return editInstanceImplementation(pThisCustomer, pCustomerName, pCustomerEmail);
	}

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.SUPPORTS)
	public Customer editInstanceImplementation(Customer pThisCustomer, String pCustomerName, String pCustomerEmail) {
		Customer instance = pThisCustomer;
		instance.setCustomerName(pCustomerName);
		instance.setCustomerEmail(pCustomerEmail);
		return repository.save(instance);
	}

	public void deleteInstance(CustomerOid pThisCustomer) {
		deleteInstanceTxn(pThisCustomer);
	}

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
			ModelException.class })
	public void deleteInstanceTxn(CustomerOid pThisCustomerOid) {
		Customer pThisCustomer = this.find(pThisCustomerOid);
		deleteInstanceImplementation(pThisCustomer);
	}

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.SUPPORTS)
	public void deleteInstanceImplementation(Customer pThisCustomer) {
		Customer instance = pThisCustomer;
		repository.delete(instance);
	}

	public void deleteCustomer(CustomerOid pThisCustomer) {
		deleteCustomerTxn(pThisCustomer);
	}

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
			Exception.class })
	public void deleteCustomerTxn(CustomerOid pThisCustomerOid) {
		Customer pThisCustomer = this.find(pThisCustomerOid);
		deleteCustomerImplementation(pThisCustomer);
	}

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.SUPPORTS)
	public void deleteCustomerImplementation(Customer pThisCustomer) {
		Customer instance = pThisCustomer;
		for (Invoice item : instance.getInvoices()) {
			invoiceService.deleteImplementation(item);
		}
		deleteInstanceImplementation(instance);
	}

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public List<Customer> findByCustomerName(String customerName) {
		return repository.findByCustomerName(customerName);
	}

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public List<Customer> findByCustomerEmail(String customerEmail) {
		return repository.findByCustomerEmail(customerEmail);
	}

	public void deleteAll() {
		repository.deleteAllInBatch();
	}

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public List<DSCustomers> piuCustomers() {
		return repository.findAll().stream().map(DSCustomers::new).collect(Collectors.toList());
	}

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public DSCustomerDetail iiuCustomerDetail(CustomerOid oid) {
		Optional<Customer> instance = repository.findById(oid);
		return (instance.isPresent() ? new DSCustomerDetail(instance.get()) : new DSCustomerDetail());
	}
}
