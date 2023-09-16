package com.sample.zoo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.zoo.dto.ValidationErrorDTO;

@SpringBootTest
@AutoConfigureMockMvc
public class AnimalControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	private String validateRequest = "[{\r\n"
			+ "  \"name\": \"tooLongNameFirst\",\r\n"
			+ "  \"owner\" : \"tooLongOwnerFirst\"\r\n"
			+ "},"
			+"{\r\n"
			+ "  \"name\": \"tooLongNameSecond\"\r\n"
			+ "}]";;
			
	private List<ValidationErrorDTO> response = new ArrayList<>();
	
	
	@Test
	public void shouldReturnErrors() throws Exception {
		ObjectMapper mapper = new ObjectMapper();

	    MvcResult mvcResult = mockMvc.perform(post("/api/v1/validate")
				.contentType(MediaType.APPLICATION_JSON)
				.content(validateRequest))
				.andExpect(status().isOk())
				.andReturn();
	    
	    response = mapper.readValue(mvcResult.getResponse().getContentAsString(), 
	    								new TypeReference<List<ValidationErrorDTO>>(){});
	    assertEquals(3, response.size());
				
	}
}
