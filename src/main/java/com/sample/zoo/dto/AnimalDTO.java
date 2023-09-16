package com.sample.zoo.dto;

import jakarta.validation.constraints.Size;

public class AnimalDTO {

	
	@Size(max = 5, message = "name can not be longer than 5")
	private String name;
	@Size(max = 5, message = "owner can not be longer than 5")
	private String owner; 
	
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AnimalDTO() {
		super();
	}

	public AnimalDTO(String name,String owner) {
		super();
		this.name = name;
		this.owner = owner;
	}
	
}
