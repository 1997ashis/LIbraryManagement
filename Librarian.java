package com.nt.model;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Map;

@Document
public class Librarian  implements Serializable
{
	@Id
	private String id;
	private String username;
    private String password;
	private Map<Object,Object> cache;
	private String  address;
	private long contactno;
	public Librarian() {
		super();

	}

	public long getContactno() {
		return contactno;
	}

	public void setContactno(long contactno) {
		this.contactno = contactno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	private String city;


	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}





	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Librarian{" +
				"id='" + id + '\'' +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", address='" + address + '\'' +
				", contactno=" + contactno +
				", city='" + city + '\'' +
				'}';
	}
}

