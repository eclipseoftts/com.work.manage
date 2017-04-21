package com.work.utils;

public class InfoError {

	private int code;
	private String error;
	
	public InfoError(){
		this.code = 0;
		this.error = "";
	}
	
	public void clear(){
		this.code = 0;
		this.error = "";
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
}
