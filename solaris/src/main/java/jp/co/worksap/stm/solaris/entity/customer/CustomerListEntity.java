package jp.co.worksap.stm.solaris.entity.customer;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerListEntity {

	private int draw;
	private int recordsTotal;
	private int recordsFiltered;
	private List<CustomerEntity> customerEntities;

}
