package ie.soft8020.philliesflowers.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Customer {

	@Id
	int id;
	
	private String name;
	private String emailAddress;
	private String comments;
	private String address;
	private String phoneNumber;
	
	public Customer(String name, String emailAddress, String comments, String address, String phoneNumber) {
		this.name = name;
		this.emailAddress = emailAddress;
		this.comments = comments;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", emailAddress=" + emailAddress + ", comments=" + comments
				+ ", address=" + address + ", phoneNumber=" + phoneNumber + "]";
	}
	
	
	
	
}
