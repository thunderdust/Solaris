package jp.co.worksap.stm.solaris.controller;

import jp.co.worksap.stm.solaris.entity.customer.CustomerCreationEntity;
import jp.co.worksap.stm.solaris.entity.customer.CustomerFetchEntity;
import jp.co.worksap.stm.solaris.entity.customer.CustomerListEntity;
import jp.co.worksap.stm.solaris.services.specification.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService cs;

	@PreAuthorize("hasAuthority('SALES MANAGER')||hasAuthority('SALES REPRESENTATIVE')||hasAuthority('AFTER-SALES SERVICE AGENT')")
	@RequestMapping(value = "/customers")
	public String customerManagement() {
		return "customers";
	}
	
	@PreAuthorize("hasAuthority('SALES MANAGER')||hasAuthority('SALES REPRESENTATIVE')")
	@RequestMapping(value = "/new_customer")
	public String findNewCustomer() {
		return "find_new_customers";
	}

	@PreAuthorize("hasAuthority('SALES MANAGER')||hasAuthority('SALES REPRESENTATIVE')||hasAuthority('AFTER-SALES SERVICE AGENT')")
	@RequestMapping(value = "/customers/getAllCustomers", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public CustomerListEntity getAllCustomers(@RequestBody CustomerFetchEntity e) {
		return cs.getAll(e);
	}

	@PreAuthorize("hasAuthority('SALES MANAGER')||hasAuthority('SALES REPRESENTATIVE')")
	@ResponseBody
	@RequestMapping(value = "/customers/addCustomer", method = RequestMethod.POST)
	public void addCustomer(@RequestBody CustomerCreationEntity cce) {
		cs.insert(cce);
	}

	@PreAuthorize("hasAuthority('SALES MANAGER')||hasAuthority('SALES REPRESENTATIVE')")
	@RequestMapping(value = "/customers/updateCustomer", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void updateCustomer(@RequestParam CustomerCreationEntity cce) {
		cs.update(cce);
	}

	@PreAuthorize("hasAuthority('SALES MANAGER')||hasAuthority('SALES REPRESENTATIVE')")
	@RequestMapping(value = "/customers/deleteCustomer", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteCustomer(@RequestParam String email) {
		cs.deleteByEmail(email);
	}

}
