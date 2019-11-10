package exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class SystemNotFoundException extends RuntimeException {
	
	public SystemNotFoundException(String message) {
		super(message);
	}

}
