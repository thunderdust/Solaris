package jp.co.worksap.stm.solaris.services.specification;

import java.util.List;

import jp.co.worksap.stm.solaris.exceptions.ServiceException;

public interface RoleService {

	List<String> getRolesByUserId(String userId) throws ServiceException;

	void insertRoles(String userId, List<String> roleList)
			throws ServiceException;

	void deleteRoles(String userId) throws ServiceException;

}
