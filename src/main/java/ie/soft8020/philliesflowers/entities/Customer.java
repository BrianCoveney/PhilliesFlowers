package ie.soft8020.philliesflowers.entities;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import ie.soft8020.philliesflowers.constants.Const;

@Document
public class Customer {

	// Required fields
	@Id
	int id;
	private String name;
	private String emailAddress;

	// Optional fields
	private String comments;
	private String address;
	private String phoneNumber;

	Customer() {
		comments = Const.ParamsNames.CUSTOMER_COMMENTS;
		address = Const.ParamsNames.CUSTOMER_ADDRESS;
		phoneNumber = Const.ParamsNames.CUSTOMER_PHONE_NUMBER;
	}


	/**
     * Creates a new Customer with default values for optional fields.
     *
     * <p>Following default values are set to corresponding attributes:
     * <ul>
     * <li>{@code Const.ParamsNames.CUSTOMER_COMMENTS} for {@code comments}</li>
     * <li>{@code Const.ParamsNames.CUSTOMER_ADDRESS} for {@code address}</li>
     * <li>{@code Const.ParamsNames.CUSTOMER_PHONE_NUMBER} for {@code phoneNumber}</li>
     * </ul>
     */
	public static Builder builder(int id, String name, String emailAddress) {
		return new Builder(id, name, emailAddress);
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

	public static class Builder {
		private final Customer customer;

		public Builder(int id, String name, String emailAddress) {

			if(name == null || emailAddress == null)
				throw new IllegalArgumentException(Const.StatusCodes.NULL_PARAMETER);

			customer = new Customer();
			customer.id = id;
			customer.name = name;
			customer.emailAddress = emailAddress;
		}

		public Builder withComments(String comments) {
			if(comments != null) {
				customer.comments = comments;
			}
			return this;
		}

		public Builder withAddress(String address) {
			if(address != null) {
				customer.address = address;
			}
			return this;
		}

		public Builder withPhoneNumber(String phoneNumber) {
			if(phoneNumber != null) {
				customer.phoneNumber = phoneNumber;
			}
			return this;
		}

		public Customer build() {
			return customer;
		}

	}

}
