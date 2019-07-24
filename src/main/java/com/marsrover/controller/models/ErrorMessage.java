package com.marsrover.controller.models;

import com.google.gson.annotations.SerializedName;

public class ErrorMessage {

	@SerializedName("error_message")
	private String errorMessage;
	
	@SerializedName("error_code")
	private int code;
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
}
