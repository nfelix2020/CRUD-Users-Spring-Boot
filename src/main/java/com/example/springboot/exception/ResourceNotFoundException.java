package com.example.springboot.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;



@ResponseStatus(value= HttpStatus.NOT_FOUND)  //Si la source n'est pas trouvé, l'exception NOT FOUND  est envoyée.
public class ResourceNotFoundException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException (String message) {  //We need to throw a message when the resource is not found
		super(message);
}
}
