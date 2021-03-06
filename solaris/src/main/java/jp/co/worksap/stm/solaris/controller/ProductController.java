package jp.co.worksap.stm.solaris.controller;


import jp.co.worksap.stm.solaris.entity.laptop.LaptopCreationEntity;
import jp.co.worksap.stm.solaris.entity.laptop.LaptopFetchEntity;
import jp.co.worksap.stm.solaris.entity.laptop.LaptopListEntity;
import jp.co.worksap.stm.solaris.services.specification.LaptopService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.base.Strings;

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
	@RequestMapping(value = "/products/show", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public LaptopListEntity getAllLaptops(@RequestBody LaptopFetchEntity e) {
		
		if (Strings.isNullOrEmpty(e.getSearchParam())){
			return laptopService.getAll(e);
		}
		else {
			return laptopService.filter(e);
		}
		
	}

	@PreAuthorize("hasAuthority('ADMIN')||hasAuthority('SALES MANAGER')")
	@ResponseBody
	@RequestMapping(value = "/products/addLaptop", method = RequestMethod.POST)
	public void addLaptop(@RequestBody LaptopCreationEntity pce) {
		laptopService.insert(pce);
	}
	
	@PreAuthorize("hasAuthority('ADMIN')||hasAuthority('SALES MANAGER')")
	@RequestMapping(value = "/products/deleteLaptop", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteLaptop(@RequestParam String name){
		laptopService.deleteByName(name);
	}

}
