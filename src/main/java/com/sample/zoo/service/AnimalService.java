package com.sample.zoo.service;

import java.util.List;

import com.sample.zoo.dto.AnimalDTO;
import com.sample.zoo.dto.ValidationErrorDTO;

public interface AnimalService {

	public List<ValidationErrorDTO>  validateCollection(List<AnimalDTO> collection);
}
