package jp.co.worksap.stm.solaris.entity;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class InventoryFetchEntity {

	private int laptopId;
	private int quantity;
	private Date createTime;
	private Date lastModified;

}
