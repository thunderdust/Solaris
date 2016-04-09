package jp.co.worksap.stm.solaris.services.implementation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jp.co.worksap.stm.solaris.dao.specification.RoleDao;
import jp.co.worksap.stm.solaris.dto.RoleDto;
import jp.co.worksap.stm.solaris.exceptions.ServiceException;
import jp.co.worksap.stm.solaris.services.specification.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImplementation implements RoleService {

	@Autowired
	RoleDao roleDao;

	@Override
	public List<String> getRolesByUserId(String userId) throws ServiceException {
		List<RoleDto> roleList;
		try {
			roleList = roleDao.getByUserId(userId);

		} catch (IOException e) {
			throw new ServiceException("Cannot fetch roles for user id: "
					+ userId, e);
		}

		List<String> roles = new ArrayList<String>();
		for (RoleDto rd : roleList) {
			roles.add(rd.getName());
		}
		return roles;
	}

	@Override
	public void insertRoles(String userId, List<String> roleList)
			throws ServiceException {
		List<RoleDto> roles = new ArrayList<RoleDto>();
		for (String role : roleList) {
			RoleDto rd = new RoleDto();
			rd.setName(role);
			roles.add(rd);
		}
		try {
			roleDao.insertRole(userId, roles);

		} catch (IOException e) {
			throw new ServiceException("Cannot add roles for user id: "
					+ userId + " roleList size: " + roleList.size(), e);
		}
	}

	@Override
	public void deleteRoles(String userId) throws ServiceException {
		try {
			roleDao.deleteRole(userId);

		} catch (IOException e) {
			throw new ServiceException("Failed to delete roles for user id: "
					+ userId, e);
		}

	}

}
