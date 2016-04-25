package jp.co.worksap.stm.solaris.controller;


import jp.co.worksap.stm.solaris.entity.order.OrderCreationEntity;
import jp.co.worksap.stm.solaris.entity.order.OrderFetchEntity;
import jp.co.worksap.stm.solaris.entity.order.OrderListEntity;
import jp.co.worksap.stm.solaris.services.specification.OrderService;

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
public class OrderController {
	
	@Autowired
	private OrderService os;

	@PreAuthorize("hasAuthority('ADMIN')||hasAuthority('SALES MANAGER')||hasAuthority('SALES REPRESENTATIVE')")
	@RequestMapping(value = "/orders")
	public String orderManagement() {
		return "orders";
	}

	@PreAuthorize("hasAuthority('SALES MANAGER')||hasAuthority('SALES REPRESENTATIVE')")
	@RequestMapping(value = "/orders/addOrder", method = RequestMethod.POST)
	@ResponseBody
	public void addOrder(@RequestBody OrderCreationEntity oce) {
		os.insert(oce);
	}

	@PreAuthorize("hasAuthority('SALES MANAGER')||hasAuthority('SALES REPRESENTATIVE')")
	@RequestMapping(value = "/orders/updateOrder", method = RequestMethod.POST)
	@ResponseBody
	public void updateUserAccount(@RequestBody OrderCreationEntity oce) {
		os.update(oce);
	}
	
	@PreAuthorize("hasAuthority('ADMIN')||hasAuthority('SALES MANAGER')||hasAuthority('SALES REPRESENTATIVE')")
	@RequestMapping(value = "/orders/deleteOrder", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteUser(@RequestParam int id) {
		os.deleteById(id);
	}

	@PreAuthorize("hasAuthority('ADMIN')||hasAuthority('SALES MANAGER')||hasAuthority('SALES REPRESENTATIVE')")
	@RequestMapping(value = "/orders/getAllOrders", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public OrderListEntity findAllUsers(@RequestBody OrderFetchEntity e) {
		return os.getAll(e);
	}


	

}
