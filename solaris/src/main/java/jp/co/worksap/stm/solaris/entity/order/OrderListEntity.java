package jp.co.worksap.stm.solaris.entity.order;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderListEntity {
	private int draw;
	private int recordsTotal;
	private int recordsFiltered;
	private List<OrderEntity> orderEntities;
}
