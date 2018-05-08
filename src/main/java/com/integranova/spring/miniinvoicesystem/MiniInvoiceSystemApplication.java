package com.integranova.spring.miniinvoicesystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.integranova.spring.miniinvoicesystem.service.CustomerService;
import com.integranova.spring.miniinvoicesystem.service.InvoiceLineService;
import com.integranova.spring.miniinvoicesystem.service.InvoiceService;

@SpringBootApplication
public class MiniInvoiceSystemApplication implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(MiniInvoiceSystemApplication.class, args);
	}

	@Autowired
	private ConfigurableApplicationContext context;

	@Autowired
	private CustomerService customerService;
	@Autowired
	private InvoiceService invoiceService;
	@Autowired
	private InvoiceLineService invoiceLineService;

	@Override
	public void run(String... args) throws Exception {

		logger.info("{}", "Start of tests");

		// invoiceLineService.deleteAll();
		// invoiceService.deleteAll();
		// customerService.deleteAll();
		//
		// Customer customer1 = customerService.newInstance("Juan Carlos",
		// "jcmolina@integranova.com");
		// logger.info("Created customer {}", customer1);
		// customer1 = customerService.editInstance(customer1.getOid(), "JC",
		// "jcmolina@care-t.com");
		// logger.info("Modified customer {}", customer1);

		// Invoice invoice1 = new Invoice(new InvoiceOid(1L),
		// customer1.getOid().getCustomerId(), new Date(),
		// "Notes for Invoice 1");
		// invoice1.setApplicationContext(context);
		// invoice1.setCustomer(customer1);
		// invoiceService.create(invoice1);
		// InvoiceLine invoiceLine11 = new InvoiceLine(new
		// InvoiceLineOid(invoice1.getOid().getInvoiceId(), 1L),
		// "Line 1, invoice 1", 1L, 10.0);
		// invoiceLine11.setInvoice(invoice1);
		// invoiceLineService.create(invoiceLine11);
		// InvoiceLine invoiceLine12 =
		// new InvoiceLine(new InvoiceLineOid(invoice1.getOid().getInvoiceId(), 2L),
		// "Line 2, invoice 1", 2L,
		// 20.0);
		// invoiceLine12.setInvoice(invoice1);
		// invoiceLineService.create(invoiceLine12);
		//
		// logger.info("{}", "About to update invoice1");
		// invoiceService.updateAll(invoice1);
		//
		// Invoice invoice2 = new Invoice(new InvoiceOid(2L),
		// customer1.getOid().getCustomerId(), new Date(),
		// "Notes for Invoice 2");
		// invoice2.setApplicationContext(context);
		// invoice2.setCustomer(customer1);
		// invoiceService.create(invoice2);
		// InvoiceLine invoiceLine21 = new InvoiceLine(new
		// InvoiceLineOid(invoice2.getOid().getInvoiceId(), 1L),
		// "Line 1, invoice 2", 1L, 10.0);
		// invoiceLine21.setInvoice(invoice2);
		// invoiceLineService.create(invoiceLine21);
		// InvoiceLine invoiceLine22 = new InvoiceLine(new
		// InvoiceLineOid(invoice2.getOid().getInvoiceId(), 2L),
		// "Line 2, invoice 2", 2L, 20.0);
		// invoiceLine22.setInvoice(invoice2);
		// invoiceLineService.create(invoiceLine22);
		//
		// logger.info("{}", "About to update invoice2");
		// invoiceService.updateAll(invoice2);
		//
		// logger.info("Customer with oid 1 is: {}", customer1);
		// logger.info("Invoice1 is : {}", invoiceService.find(1L));
		// logger.info("Invoices of customer 1 are: {}",
		// invoiceService.findByCustomer(customer1));
		// logger.info("Invoices of customer 'Juan Carlos' are: {}",
		// invoiceService.findByCustomerName(customer1.getCustomerName()));
		// logger.info("Customer with email 'jcmolina@integranova.com' is: {}",
		// customerService.findByCustomerEmail("jcmolina@integranova.co"));
		// logger.info("Lines of invoice1 are: {}",
		// invoiceLineService.findByInvoice(invoice1));
		// logger.info("Lines of invoice2 are: {}",
		// invoiceLineService.findByInvoice(invoice2));
		//
		// logger.info("These are all the lines: {}",
		// invoiceLineService.piuInvoiceLines());

	}
}
