package com.sample.zoo.service.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.sample.zoo.dto.AnimalDTO;
import com.sample.zoo.service.AnimalService;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import com.sample.zoo.dto.ValidationErrorDTO;

@Component
public class AnimalServiceImpl implements AnimalService{

	@Override
	public List<ValidationErrorDTO> validateCollection(List<AnimalDTO> collection) {
		
		List<ValidationErrorDTO> validationErrorList = new ArrayList<>();
		
		//instantiate the validator
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        
        //for every record of the collection, validate the record and add errors to the error list
        for(int i= 0; i<collection.size();i++) {

        	int k =i;
            //get single record errors
            Set<ConstraintViolation<AnimalDTO>> violations = validator.validate(collection.get(i));

            violations.forEach(v -> validationErrorList.add(new ValidationErrorDTO(k, v.getPropertyPath().toString(), v.getMessage())));
        }
        
        return validationErrorList;
	}

}
