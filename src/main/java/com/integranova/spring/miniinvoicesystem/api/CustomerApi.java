package com.integranova.spring.miniinvoicesystem.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.integranova.spring.miniinvoicesystem.entity.Customer;
import com.integranova.spring.miniinvoicesystem.entity.oid.CustomerOid;
import com.integranova.spring.miniinvoicesystem.service.CustomerService;
import com.integranova.spring.miniinvoicesystem.viewmodel.customer.ds.DSCustomerDetail;
import com.integranova.spring.miniinvoicesystem.viewmodel.customer.ds.DSCustomers;
import com.integranova.spring.miniinvoicesystem.viewmodel.customer.siu.DeleteCustomerRequest;
import com.integranova.spring.miniinvoicesystem.viewmodel.customer.siu.DeleteInstanceRequest;
import com.integranova.spring.miniinvoicesystem.viewmodel.customer.siu.EditInstanceRequest;
import com.integranova.spring.miniinvoicesystem.viewmodel.customer.siu.NewInstanceRequest;

@RestController
@RequestMapping("/api/Customer")
public class CustomerApi {

	@Autowired
	CustomerService service;

	@RequestMapping(value = "/newInstance", method = RequestMethod.POST)
	public Customer newInstance(@RequestParam NewInstanceRequest request) {
		return service.newInstance(request.getpAtrcustomerName(), request.getpAtrCustomerEmail());
	}

	@RequestMapping(value = "/editInstance", method = RequestMethod.POST)
	public Customer editInstance(@RequestParam EditInstanceRequest request) {
		return service.editInstance(request.getpThisCustomer(), request.getpCustomerName(),
				request.getpCustomerEmail());
	}

	@RequestMapping(value = "/deleteInstance", method = RequestMethod.POST)
	public void deleteInstance(@RequestParam DeleteInstanceRequest request) {
		service.deleteInstance(request.getpThisCustomer());
	}

	@RequestMapping(value = "/deleteCustomer", method = RequestMethod.POST)
	public void deleteCustomer(@RequestParam DeleteCustomerRequest request) {
		service.deleteCustomer(request.getpThisCustomer());
	}

	@RequestMapping(value = "/Customers", method = RequestMethod.GET)
	public List<DSCustomers> piuCustomers() {
		return service.piuCustomers();
	}

	@RequestMapping(value = "/CustomerDetail", method = RequestMethod.GET, params = { "customerId" })
	public DSCustomerDetail iiuCustomerDetail(@RequestParam() Long customerId) {
		return service.iiuCustomerDetail(new CustomerOid(customerId));
	}
}
