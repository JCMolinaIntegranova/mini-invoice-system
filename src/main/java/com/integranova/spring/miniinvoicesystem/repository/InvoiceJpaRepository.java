package com.integranova.spring.miniinvoicesystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.integranova.spring.miniinvoicesystem.entity.Invoice;
import com.integranova.spring.miniinvoicesystem.entity.oid.InvoiceOid;

@Repository
public interface InvoiceJpaRepository extends JpaRepository<Invoice, InvoiceOid> {

	List<Invoice> findByCustomerId(Long customerId);

	List<Invoice> findByCustomerCustomerName(String customerName);
}
