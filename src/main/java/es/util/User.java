package es.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@EsType("user")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
	@EsId
	private String id;
	private String name;
	private String job;

	private User.Address address;

	public User() {
	}

	public User(String id, String name, String job, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.job = job;
		this.address = address;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public User.Address getAddress() {
		return address;
	}

	public void setAddress(User.Address address) {
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static class Address {

		private String street;

		private String city;

		public Address() {

		}

		public Address(String street, String city) {
			super();
			this.street = street;
			this.city = city;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getStreet() {
			return street;
		}

		public void setStreet(String street) {
			this.street = street;
		}

		@Override
		public String toString() {
			return "Address [street=" + street + ", city=" + city + "]";
		}

	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", job=" + job + ", address=" + address + "]";
	}

}
