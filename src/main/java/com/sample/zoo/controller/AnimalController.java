package com.sample.zoo.controller;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sample.zoo.dto.AnimalDTO;
import com.sample.zoo.dto.ValidationErrorDTO;
import com.sample.zoo.service.AnimalService;

import jakarta.validation.ConstraintViolation;

@RestController
@RequestMapping(value = "/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class AnimalController {

		AnimalService service;
		
	 	@PostMapping("/validate")
	    @ResponseStatus(value = HttpStatus.OK)
	    public List<ValidationErrorDTO>  validateCollection(@RequestBody List<AnimalDTO> request)
	                                                    {
	 		return service.validateCollection(request);
	    }
	 	
	 	
		public AnimalController(AnimalService service) {
			super();
			this.service = service;
		}
	 	
	 	
}
