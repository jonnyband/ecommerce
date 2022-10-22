package com.grupo2.ecommerce.model.error;

import java.util.Date;

public class ErrorMessage {

	private String dateTime;
	
	private Integer status;
	
	private String title;
	
	private String message;
	
	public ErrorMessage(String dateTime, Integer status, String title, String message) {
		this.dateTime = dateTime;
		this.status = status;
		this.title = title;
		this.message = message;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}	
	
	
}
