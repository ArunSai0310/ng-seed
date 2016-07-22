package io.arun.movies_hub.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code=HttpStatus.BAD_REQUEST,reason="Movie already exists")
public class MovieAlreadyExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MovieAlreadyExistException(String message)
	{
		super(message);
	}
	
	public MovieAlreadyExistException(String message, Throwable cause)
	{
		super(message,cause);
	}
	
}
