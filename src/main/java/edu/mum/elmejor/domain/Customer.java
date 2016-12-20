package edu.mum.elmejor.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@Column(name = "customer_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "first_name", nullable = false, length = 50)
	@NotEmpty
	private String firstName;

	@Column(name = "last_name", nullable = false, length = 50)
	@NotEmpty
	private String lastName;

	@Column(name = "email", nullable = false, length = 50)
	@NotEmpty
	@Email
	private String email;

	@Valid
	@OneToOne(mappedBy = "customer", fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Address address = new Address();

	/**
	 * Given below are getter and setters of attributes above
	 */

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("First Name : " + this.firstName + "\n");
		sb.append("Last Name : " + this.lastName + "\n");
		sb.append("Email : " + this.email + "\n");

		return sb.toString();

	}
}
