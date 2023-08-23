package spring.log.exception;

public enum ErrorCode {

	Bad_Request("Bad Request"), Internal_Server_Error("Internal Server Error"),	Invalid_Json_Body("invalid or empty json body"),
	DataNotFound("Data Not Found"),

	;

	private String description;

	private ErrorCode(String description) {
		this.description = description;
	}

	public String getErrorDescrption() {
		return this.description;
	}
}
