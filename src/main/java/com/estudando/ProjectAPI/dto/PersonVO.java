package com.estudando.ProjectAPI.dto;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

public class PersonVO extends RepresentationModel<PersonVO> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String address;
	private String first_name;
	private String gender;
	private String last_name;

	public PersonVO() {
	}

	public PersonVO(Long id, String address, String first_name, String gender, String last_name) {

		this.id = id;
		this.address = address;
		this.first_name = first_name;
		this.gender = gender;
		this.last_name = last_name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

}
