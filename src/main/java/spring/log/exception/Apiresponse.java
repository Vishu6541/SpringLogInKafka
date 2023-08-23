package spring.log.exception;

public class Apiresponse {

	private String status;
	private int statusCode;
	private Object data;
	private String message;

	public Apiresponse(String status, int statusCode, Object data, String message) {
		super();
		this.status = status;
		this.statusCode = statusCode;
		this.data = data;
		this.message = message;
	}

	public Apiresponse(String status, int statusCode, Object data) {
		super();
		this.status = status;
		this.statusCode = statusCode;
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	};

}
