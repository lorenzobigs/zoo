package com.sample.zoo.dto;

import jakarta.validation.constraints.NotBlank;

public class CatDTO extends AnimalDTO{
	
	@NotBlank
	private boolean mustaches;
}
