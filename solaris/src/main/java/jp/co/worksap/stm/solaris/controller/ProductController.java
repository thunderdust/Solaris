package jp.co.worksap.stm.solaris.controller;

import jp.co.worksap.stm.solaris.services.specification.LaptopService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

	@Autowired
	private LaptopService laptopService;

	@PreAuthorize("hasAuthority('ADMIN')||hasAuthority('SALES MANAGER')||hasAuthority('SALES REPRESENTATIVE')")
	@RequestMapping(value = "/products")
	public String productManagement() {
		return "products";
	}

	@PreAuthorize("hasAuthority('ADMIN')||hasAuthority('SALES MANAGER')||hasAuthority('SALES REPRESENTATIVE')")
	@RequestMapping(value = "/products-add")
	public String addProduct() {
		return "products-add";
	}

}
