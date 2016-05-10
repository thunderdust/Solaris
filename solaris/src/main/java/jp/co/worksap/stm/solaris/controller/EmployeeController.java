package jp.co.worksap.stm.solaris.controller;

import jp.co.worksap.stm.solaris.entity.employee.EmployeeCreationEntity;
import jp.co.worksap.stm.solaris.entity.employee.EmployeeFetchAllEntity;
import jp.co.worksap.stm.solaris.entity.employee.EmployeeListEntity;
import jp.co.worksap.stm.solaris.services.specification.EmployeeService;

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
	@RequestMapping(value = "/employees/updateUserAccount", method = RequestMethod.POST)
	@ResponseBody
	public void updateUserAccount(@RequestBody EmployeeCreationEntity ece) {
		employeeService.update(ece);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/employees/show", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public EmployeeListEntity show(@RequestBody EmployeeFetchAllEntity e) {
		// Show all if no search filter
		if (Strings.isNullOrEmpty(e.getSearchParam())) {
			return employeeService.getAll(e);
		} else {
			return employeeService.filter(e);
		}
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/employees/deleteUser", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteUser(@RequestParam String userID) {
		employeeService.deleteById(userID);
	}
}