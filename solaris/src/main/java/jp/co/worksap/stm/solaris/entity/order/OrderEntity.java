package jp.co.worksap.stm.solaris.entity.order;

import java.sql.Date;

import jp.co.worksap.stm.solaris.dto.OrderDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderEntity {

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

	public OrderEntity(OrderDto od) {

		this.clientEmail = od.getClientEmail();
		this.clientName = od.getClientName();
		this.createdDate = od.getCreatedDate();
		this.deliveryDeadline = od.getDeliveryDeadline();
		this.id = od.getId();
		this.laptopName = od.getLaptopName();
		this.lastModified = od.getLastModified();
		this.quantity = od.getQuantity();
		this.sellerId = od.getSellerId();
		this.price = od.getPrice();
	}
}
