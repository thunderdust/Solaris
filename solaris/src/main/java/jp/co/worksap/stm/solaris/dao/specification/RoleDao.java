package jp.co.worksap.stm.solaris.dao.specification;

import java.io.IOException;
import java.util.List;

import jp.co.worksap.stm.solaris.dto.RoleDto;

public interface RoleDao {

	List<RoleDto> getByUserId(String userId) throws IOException;

	void insertRole(String userId, List<RoleDto> roleList) throws IOException;
	
	void deleteRole(String userId) throws IOException;
}
