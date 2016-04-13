package jp.co.worksap.stm.solaris.services.specification;

import jp.co.worksap.stm.solaris.entity.LaptopFetchEntity;
import jp.co.worksap.stm.solaris.entity.LaptopListEntity;
import jp.co.worksap.stm.solaris.exceptions.ServiceException;

public interface LaptopService {

	LaptopListEntity getAll(LaptopFetchEntity e) throws ServiceException;

	void deleteByName(String name) throws ServiceException;

	void update(String name) throws ServiceException;

}
