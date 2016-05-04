package jp.co.worksap.stm.solaris.utils;

import java.security.Principal;
import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class AuthorityHelper {

	private Principal p;
	private User user;
	private Collection<GrantedAuthority> authorityCollection;

	public AuthorityHelper(Principal p) {
		this.p = p;
		this.user = (User) ((Authentication) p).getPrincipal();
		this.authorityCollection = this.user.getAuthorities();
	}

	public String getUsername() {
		return this.user.getUsername();
	}

	public Collection<GrantedAuthority> getGrantedAuthorities() {
		return this.authorityCollection;
	}

	public boolean hasAuthority(String roleName) {
		Iterator<GrantedAuthority> ig = authorityCollection.iterator();
		while (ig.hasNext()) {
			GrantedAuthority thisAu = ig.next();
			String thisAuthorityString = thisAu.getAuthority();
			if (thisAuthorityString.contains(roleName)) {
				return true;
			}
		}
		return false;
	}
}
