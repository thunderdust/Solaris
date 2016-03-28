package jp.co.worksap.stm.solaris.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryListEntity {
	private int laptopId;
	private int quantity;
	private Date createTime;
	private Date lastModified;

}
