package jp.co.worksap.stm.solaris.entity;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class CurrentUser extends User {

	private static final long serialVersionUID = -456957226956267499L;
	private EmployeeEntity user;

	public CurrentUser(EmployeeEntity user) {
		super(Integer.toString(user.getId()), user.getPassword(),
				AuthorityUtils.createAuthorityList(user.getRole()));
		this.user = user;
	}

	public EmployeeEntity getUser() {
		return user;
	}

	public int getId() {
		return user.getId();
	}

	public String getRole() {
		return user.getRole();
	}
}
