package jp.co.worksap.stm.solaris.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDto {
	
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

}
