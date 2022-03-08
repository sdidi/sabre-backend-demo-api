package za.co.sabre.converter.exception;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MetricUnitResponseEntityExceptionHandler
		extends ResponseEntityExceptionHandler
{

	@ExceptionHandler(value
			= { IllegalArgumentException.class, IllegalStateException.class })
	protected ResponseEntity<Object> handleConflict(
			RuntimeException ex, WebRequest request) {
		String bodyOfResponse = "Invalid Enums on the parameters - check ";
		return handleExceptionInternal(ex, bodyOfResponse,
				new HttpHeaders(), HttpStatus.CONFLICT, request);
	}
}
