package com.integranova.spring.miniinvoicesystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.integranova.spring.miniinvoicesystem.entity.InvoiceLine;
import com.integranova.spring.miniinvoicesystem.entity.oid.InvoiceLineOid;

@Repository
public interface InvoiceLineJpaRepository extends JpaRepository<InvoiceLine, InvoiceLineOid> {

	List<InvoiceLine> findByInvoiceId(Long invoiceId);
}
