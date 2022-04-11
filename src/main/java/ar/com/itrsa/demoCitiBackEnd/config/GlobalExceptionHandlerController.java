package ar.com.itrsa.demoCitiBackEnd.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandlerController extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
	    Map<String, Object> body = new HashMap<String, Object>();
	    body.put("status", HttpStatus.BAD_REQUEST.value());
	    body.put("error", "Bad Request");
	    body.put("message", "Los valores enviados como parámetros no tiene un formato válido");
	    return new ResponseEntity<Object>(body, new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

	    Map<String, Object> body = new HashMap<String, Object>();
	    body.put("status", HttpStatus.BAD_REQUEST.value());
	    body.put("error", "Bad Request");
	    body.put("message", "Los valores enviados como parámetros no tiene un formato válido");
	    return new ResponseEntity<Object>(body, new HttpHeaders(), HttpStatus.BAD_REQUEST);

	}
}
