package jp.co.worksap.stm.solaris.controller;

import jp.co.worksap.stm.solaris.entity.LaptopCreationEntity;
import jp.co.worksap.stm.solaris.services.specification.LaptopService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController {

	@Autowired
	private LaptopService laptopService;

	@PreAuthorize("hasAuthority('ADMIN')||hasAuthority('SALES MANAGER')||hasAuthority('SALES REPRESENTATIVE')")
	@RequestMapping(value = "/products")
	public String productManagement() {
		return "products";
	}

	@PreAuthorize("hasAuthority('ADMIN')||hasAuthority('SALES MANAGER')")
	@RequestMapping(value = "/products-add")
	public String productAdd() {
		return "products-add";
	}

	@PreAuthorize("hasAuthority('ADMIN')||hasAuthority('SALES MANAGER')")
	@ResponseBody
	@RequestMapping(value = "/products-add/addLaptop", method = RequestMethod.POST)
	public void addLaptop(@RequestBody LaptopCreationEntity pce) {
		laptopService.insert(pce);
	}

}