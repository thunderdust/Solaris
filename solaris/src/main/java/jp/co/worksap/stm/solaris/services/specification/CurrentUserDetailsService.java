package jp.co.worksap.stm.solaris.services.specification;

import jp.co.worksap.stm.solaris.entity.CurrentUser;
import jp.co.worksap.stm.solaris.exceptions.ServiceException;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface CurrentUserDetailsService extends UserDetailsService {

	CurrentUser loadUserByUsername(String id) throws ServiceException;
}
