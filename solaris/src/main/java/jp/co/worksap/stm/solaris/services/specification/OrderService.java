package jp.co.worksap.stm.solaris.services.specification;

import jp.co.worksap.stm.solaris.entity.order.OrderCreationEntity;
import jp.co.worksap.stm.solaris.entity.order.OrderEntity;
import jp.co.worksap.stm.solaris.entity.order.OrderFetchEntity;
import jp.co.worksap.stm.solaris.entity.order.OrderListEntity;
import jp.co.worksap.stm.solaris.exceptions.ServiceException;

public interface OrderService {

	OrderEntity getById(int id) throws ServiceException;

	OrderListEntity getListByClientEmail(String email) throws ServiceException;

	OrderListEntity filter(OrderFetchEntity entity) throws ServiceException;
	
	OrderListEntity getAll(OrderFetchEntity entity) throws ServiceException;

	void insert(OrderCreationEntity e) throws ServiceException;

	void update(OrderCreationEntity e) throws ServiceException;

	void deleteById(int id) throws ServiceException;
}
