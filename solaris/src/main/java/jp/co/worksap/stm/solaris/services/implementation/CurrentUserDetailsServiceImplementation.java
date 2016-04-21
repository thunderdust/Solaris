package jp.co.worksap.stm.solaris.services.implementation;

import jp.co.worksap.stm.solaris.entity.CurrentUser;
import jp.co.worksap.stm.solaris.entity.employee.EmployeeEntity;
import jp.co.worksap.stm.solaris.services.specification.CurrentUserDetailsService;
import jp.co.worksap.stm.solaris.services.specification.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserDetailsServiceImplementation implements
		CurrentUserDetailsService {

	private final EmployeeService userService;

	@Autowired
	public CurrentUserDetailsServiceImplementation(EmployeeService userService) {
		this.userService = userService;
	}

	@Override
	public CurrentUser loadUserByUsername(String accountName)
			throws UsernameNotFoundException {
		EmployeeEntity user = userService.getById(accountName);
		if (user == null) {
			throw new UsernameNotFoundException(String.format(
					"User with account name=%s was not found", accountName));
		}

		return new CurrentUser(user);
	}

}
