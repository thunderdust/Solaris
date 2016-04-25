package jp.co.worksap.stm.solaris.entity.order;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderFetchEntity {

	private int id;
	private String clientEmail;
	private String clientName;
	private String laptopName;
	private int quantity;
	private float price;
	private String sellerId;
	private Date deliveryDeadline;
	private Date createdDate;
	private Date lastModified;

	private String searchParam;
	private int draw;
	private int start;
	private int length;
}
