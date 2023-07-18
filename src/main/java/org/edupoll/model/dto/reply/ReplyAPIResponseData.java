package org.edupoll.model.dto.reply;

public class ReplyAPIResponseData {
	
	boolean result;

	
	public ReplyAPIResponseData() {
		super();
	}
	
	public ReplyAPIResponseData(boolean result) {
		super();
		this.result = result;
	}
	
	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}
}
