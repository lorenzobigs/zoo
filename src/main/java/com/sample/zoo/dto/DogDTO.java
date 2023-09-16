package com.sample.zoo.dto;

import jakarta.validation.constraints.Size;

public class DogDTO extends AnimalDTO{

	@Size(max = 3, message = "dog bark can not be longer than 3")
	private String bark;
}
