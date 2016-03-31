package jp.co.worksap.stm.solaris.services.implementation;

import jp.co.worksap.stm.solaris.entity.CurrentUser;
import jp.co.worksap.stm.solaris.entity.EmployeeEntity;
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
	public CurrentUser loadUserByUsername(String id)
			throws UsernameNotFoundException {
		EmployeeEntity user = userService.getById(id);
		if (user == null) {
			throw new UsernameNotFoundException(String.format(
					"User with id=%s was not found", id));
		}

		return new CurrentUser(user);
	}

}
