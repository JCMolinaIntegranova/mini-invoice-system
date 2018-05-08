package com.integranova.spring.miniinvoicesystem.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.integranova.spring.miniinvoicesystem.service.InvoiceLineService;
import com.integranova.spring.miniinvoicesystem.viewmodel.invoiceline.ds.DSInvoiceLine;

@RestController
@RequestMapping("/api/InvoiceLine")
public class InvoceLineApi {

	@Autowired
	InvoiceLineService service;

	/**
	 * InvoiceLines query
	 * 
	 * @return List of DSInvoiceLine
	 */
	@RequestMapping("/InvoiceLines")
	public List<DSInvoiceLine> postInvoiceLines() {
		return service.piuInvoiceLines();
	}

}
