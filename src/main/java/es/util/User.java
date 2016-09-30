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

	private Address address;


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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
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



	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", job=" + job + ", address=" + address + "]";
	}
	
	public static class City {
		private String cityName;
		private String areaCode;

		public City() {
		}

		public City(String cityName, String areaCode) {
			super();
			this.cityName = cityName;
			this.areaCode = areaCode;
		}

		public String getCityName() {
			return cityName;
		}

		public void setCityName(String cityName) {
			this.cityName = cityName;
		}

		public String getAreaCode() {
			return areaCode;
		}

		public void setAreaCode(String areaCode) {
			this.areaCode = areaCode;
		}

		@Override
		public String toString() {
			return "City [cityName=" + cityName + ", areaCode=" + areaCode + "]";
		}

	}	
	
	public static class Address {

		private String street;

		//private City city;

		public Address() {

		}
		public Address(String street ) {
			super();
			this.street = street;
			//this.city = city;
		}
		


		
		private City city ;

		public City getCity() {
			return city;
		}

		public void setCity(City city) {
			this.city = city;
		}		
		
		
		//		public City getCity() {
//			return city;
//		}
//
//		public void setCity(City city) {
//			this.city = city;
//		}

		public String getStreet() {
			return street;
		}

		public void setStreet(String street) {
			this.street = street;
		}

		@Override
		public String toString() {
			return "Address [street=" + street + ", city=" + "city" + "]";
		}


	}	

}
