package com.sample.zoo.dto;

public class ValidationErrorDTO {

	 private Integer index;
	    private String  field;
		private String  message;
		
	    public Integer getIndex() {
	        return index;
	    }

	    public void setIndex(Integer index) {
	        this.index = index;
	    }

	    public String getField() {
	        return field;
	    }

	    public void setField(String field) {
	        this.field = field;
	    }

	    public String getMessage() {
	        return message;
	    }

	    public void setMessage(String message) {
	        this.message = message;
	    }

	    public ValidationErrorDTO(Integer index, String field, String message) {
	        this.index = index;
	        this.field = field;
	        this.message = message;
	    }

	    public ValidationErrorDTO() {
	    }
}
