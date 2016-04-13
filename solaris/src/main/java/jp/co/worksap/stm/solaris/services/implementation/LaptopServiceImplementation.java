package jp.co.worksap.stm.solaris.services.implementation;

import jp.co.worksap.stm.solaris.entity.LaptopFetchEntity;
import jp.co.worksap.stm.solaris.entity.LaptopListEntity;
import jp.co.worksap.stm.solaris.exceptions.ServiceException;
import jp.co.worksap.stm.solaris.services.specification.LaptopService;

import org.springframework.stereotype.Service;

@Service
public class LaptopServiceImplementation implements LaptopService {

	@Override
	public LaptopListEntity getAll(LaptopFetchEntity e) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteByName(String name) throws ServiceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(String name) throws ServiceException {
		// TODO Auto-generated method stub

	}

}
