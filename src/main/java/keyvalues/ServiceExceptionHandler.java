package keyvalues;

import javax.servlet.http.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.*;
import org.springframework.http.*;

@ControllerAdvice(basePackageClasses = KeyValueService.class)
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