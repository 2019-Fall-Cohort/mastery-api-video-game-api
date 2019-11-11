package org.wcci.apimastery.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PublisherNotFoundException extends RuntimeException {
	
	public PublisherNotFoundException(String message) {
		super(message);
	}

}
