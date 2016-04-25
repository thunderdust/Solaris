package jp.co.worksap.stm.solaris.services.implementation;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import jp.co.worksap.stm.solaris.dao.specification.OrderDao;
import jp.co.worksap.stm.solaris.dto.OrderDto;
import jp.co.worksap.stm.solaris.entity.order.OrderCreationEntity;
import jp.co.worksap.stm.solaris.entity.order.OrderEntity;
import jp.co.worksap.stm.solaris.entity.order.OrderFetchEntity;
import jp.co.worksap.stm.solaris.entity.order.OrderListEntity;
import jp.co.worksap.stm.solaris.exceptions.ServiceException;
import jp.co.worksap.stm.solaris.services.specification.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

@Service
public class OrderServiceImplementation implements OrderService {

	@Autowired
	private OrderDao od;

	@Override
	public OrderEntity getById(int id) throws ServiceException {
		OrderDto dto = null;
		try {
			dto = od.getById(id);
		} catch (IOException e) {
			throw new ServiceException("Cannot find order for id: " + id, e);
		}
		OrderEntity entity = null;
		if (dto != null) {
			entity = new OrderEntity(dto);

		}
		return entity;
	}

	@Override
	public OrderListEntity getListByClientEmail(String email)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderListEntity getAll(OrderFetchEntity entity)
			throws ServiceException {
		List<OrderDto> dtoList = null;
		int count = 0;
		try {
			dtoList = od.getAll();
			count = od.getTotalCount();

		} catch (IOException e) {
			throw new ServiceException("Error get all employees", e);
		}

		List<OrderEntity> entities = Lists.newArrayList();
		for (OrderDto dto : dtoList) {
			OrderEntity newEntity = new OrderEntity(dto);
			entities.add(newEntity);
		}

		return new OrderListEntity(entities, count, count, entity.getDraw());
	}

	@Override
	@Transactional
	public void insert(OrderCreationEntity oe) throws ServiceException {

		OrderDto dto = new OrderDto();
		dto.setClientEmail(oe.getClientEmail());
		dto.setClientName(oe.getClientName());
		dto.setCreatedDate(oe.getCreatedDate());
		dto.setDeliveryDeadline(oe.getDeliveryDeadline());
		dto.setId(oe.getId());
		dto.setLaptopName(oe.getLaptopName());
		dto.setLastModified(oe.getLastModified());
		dto.setPrice(oe.getPrice());
		dto.setQuantity(oe.getQuantity());
		dto.setSellerId(oe.getSellerId());
		

		try {
			od.insert(dto);
		} catch (IOException e) {
			throw new ServiceException("Cannot add order with id: "
					+ oe.getId(), e);
		}
	}

	@Override
	public void update(OrderCreationEntity e) throws ServiceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(int id) throws ServiceException {
		// TODO Auto-generated method stub

	}

}
