package com.app.micro.customerprofile.errormgnt;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.app.micro.customerprofile.service.CustomerService;

@ControllerAdvice(basePackageClasses = CustomerService.class)
public class ServiceExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(ServiceException.class)
	@ResponseBody
	ResponseEntity<?> handleControllerException(HttpServletRequest request,
			Throwable ex) {
		Integer errorCode = ((ServiceException) ex).getErrorCode();
		HttpStatus status = HttpStatus.valueOf(errorCode);
		return new ResponseEntity<>(new ServiceErrorResponse(errorCode, false,
				ex.getMessage()), status);
	}
}