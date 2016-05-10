package jp.co.worksap.stm.solaris.services.specification;


import jp.co.worksap.stm.solaris.entity.laptop.LaptopCreationEntity;
import jp.co.worksap.stm.solaris.entity.laptop.LaptopFetchEntity;
import jp.co.worksap.stm.solaris.entity.laptop.LaptopListEntity;
import jp.co.worksap.stm.solaris.exceptions.ServiceException;

public interface LaptopService {

	LaptopListEntity getAll(LaptopFetchEntity e) throws ServiceException;
	
	void insert(LaptopCreationEntity e) throws ServiceException;

	void deleteByName(String name) throws ServiceException;

	void update(String name) throws ServiceException;
	
	LaptopListEntity filter(LaptopFetchEntity e) throws ServiceException;

}
