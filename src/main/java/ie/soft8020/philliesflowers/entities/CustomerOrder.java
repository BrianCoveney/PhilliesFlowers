package ie.soft8020.philliesflowers.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class CustomerOrder {
	
	@Id
	int id;
	
	private Date createDate;
	private Date shippedDate;
	private String customerName;
	private String status;
	
	
	public CustomerOrder(int id, Date createDate, Date shippedDate, String customerName, String status) {
		this.id = id;
		this.createDate = createDate;
		this.shippedDate = shippedDate;
		this.customerName = customerName;
		this.status = status;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public Date getShippedDate() {
		return shippedDate;
	}


	public void setShippedDate(Date shippedDate) {
		this.shippedDate = shippedDate;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "CustomerOrder [id=" + id + ", createDate=" + createDate + ", shippedDate=" + shippedDate
				+ ", customerName=" + customerName + ", status=" + status + "]";
	}

}
