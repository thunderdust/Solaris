package jp.co.worksap.stm.solaris.entity;

import java.util.List;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class CurrentUser extends User {

	private static final long serialVersionUID = -456957226956267499L;
	private EmployeeEntity user;

	public CurrentUser(EmployeeEntity user) {
		super(user.getId(), user.getPassword(), AuthorityUtils
				.createAuthorityList(user.getRoles().toArray(
						new String[user.getRoles().size()])));
		this.user = user;
	}

	public EmployeeEntity getUser() {
		return user;
	}

	public String getId() {
		return user.getId();
	}

	public List<String> getRole() {
		return user.getRoles();
	}
}
