package com.zopper.bsi.exceptions;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by sudhir on 20/5/16.
 */
@ControllerAdvice
public class ExceptionHandler {

	org.slf4j.Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

	@org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public APIException processValidationError(MethodArgumentNotValidException ex) {
		BindingResult result = ex.getBindingResult();
		FieldError error = result.getFieldError();
		logger.error(ex.getLocalizedMessage(), ex);
		if (error != null) {
			return new APIException(HttpStatus.BAD_REQUEST.toString(), error.getField() + " " + error.getDefaultMessage());
		}
		return new APIException(HttpStatus.BAD_REQUEST.toString(), ex.getMessage());
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(APIException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public APIException handleCustomException(APIException ex) {
		logger.error(ex.getLocalizedMessage(), ex);
		return ex;
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public APIException generalExceptionHandler(Exception ex) {
		logger.error(ex.getLocalizedMessage(), ex);
		return new APIException(HttpStatus.INTERNAL_SERVER_ERROR + "", ex.getMessage());
	}

}