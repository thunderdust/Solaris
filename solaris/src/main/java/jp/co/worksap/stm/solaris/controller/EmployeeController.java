package jp.co.worksap.stm.solaris.controller;

import jp.co.worksap.stm.solaris.entity.EmployeeCreationEntity;
import jp.co.worksap.stm.solaris.entity.EmployeeFetchByRoleEntity;
import jp.co.worksap.stm.solaris.entity.EmployeeListEntity;
import jp.co.worksap.stm.solaris.services.specification.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/employees")
	public String employeeManagement() {
		return "employees";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/employees/addUserAccount", method = RequestMethod.POST)
	@ResponseBody
	public void addUserAccount(@RequestBody EmployeeCreationEntity ece) {
		employeeService.insert(ece);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/employees/findUserByRole", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public EmployeeListEntity findUserByRole(
			@RequestBody EmployeeFetchByRoleEntity e) {
		return employeeService.getListByRole(e);
	}
}