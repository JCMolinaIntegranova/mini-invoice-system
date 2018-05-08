package com.integranova.spring.miniinvoicesystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.integranova.spring.miniinvoicesystem.entity.Customer;
import com.integranova.spring.miniinvoicesystem.entity.oid.CustomerOid;

@Repository
public interface CustomerJpaRepository extends JpaRepository<Customer, CustomerOid> {

	List<Customer> findByCustomerName(String customerName);

	List<Customer> findByCustomerEmail(String customerEmail);
}
