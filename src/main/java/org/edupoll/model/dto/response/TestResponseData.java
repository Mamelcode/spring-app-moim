package org.edupoll.model.dto.response;

public class TestResponseData {
	int code;
	String message;
	
	String[] results;

	public TestResponseData(int code, String message, String[] results) {
		super();
		this.code = code;
		this.message = message;
		this.results = results;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public String[] getResults() {
		return results;
	}
}
