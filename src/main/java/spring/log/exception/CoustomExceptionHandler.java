package spring.log.exception;

import java.time.ZonedDateTime;

import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class CoustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<String> handleServiceException(ServiceException e, WebRequest request) {

		JSONObject responseObject = new JSONObject();
		responseObject.put("timestemp", ZonedDateTime.now());
		responseObject.put("errorCode", e.getErrorCode());
		responseObject.put("message",
				(StringUtils.isEmpty(e.getMessage()) ? e.getMessage() : e.getErrorCode().getErrorDescrption()));
		responseObject.put("status", "Failed");
		responseObject.put("statusCode", e.getHttpStatus().value());

		return ResponseEntity.status(e.getHttpStatus()).header("Content-Type", "application/json")
				.body(responseObject.toString());

	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleGlobalException(ServiceException e, WebRequest request) {

		JSONObject responseObject = new JSONObject();
		responseObject.put("timestemp", ZonedDateTime.now());
		responseObject.put("errorCode", e.getErrorCode());
		responseObject.put("message",
				(StringUtils.isEmpty(e.getMessage()) ? e.getMessage() : e.getErrorCode().getErrorDescrption()));
		responseObject.put("status", "Internal Server Error");

		return ResponseEntity.status(e.getHttpStatus()).header("Content-Type", "application/json")
				.body(responseObject.toString());

	}

}
