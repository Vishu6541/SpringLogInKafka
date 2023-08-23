package spring.log.exception;

import org.springframework.http.HttpStatus;

public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private ErrorCode errorCode;
	private String message;
	private HttpStatus httpStatus;

	public ServiceException(ErrorCode errorCode, HttpStatus httpStatus) {
		super(errorCode.getErrorDescrption());
		this.errorCode = errorCode;
		this.httpStatus = httpStatus;
	}

	public ServiceException(ErrorCode errorCode, String message, HttpStatus httpStatus) {
		super(message);
		this.errorCode = errorCode;
		this.message = message;
		this.httpStatus = httpStatus;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public String getMessage() {
		return message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

}
