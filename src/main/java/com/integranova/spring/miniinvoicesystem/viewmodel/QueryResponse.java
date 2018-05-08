package com.integranova.spring.miniinvoicesystem.viewmodel;

import java.util.Arrays;

import com.integranova.spring.miniinvoicesystem.exception.ModelException;

public class QueryResponse {

	private String resultCode;

	private String resultDescription;

	private int totalItems;

	public QueryResponse() {
		super();
		this.resultCode = "000";
		this.resultDescription = "OK";
		this.totalItems = 0;
	}

	public QueryResponse(String resultCode, String resultDescription) {
		super();
		this.resultCode = resultCode;
		this.resultDescription = resultDescription;
		this.totalItems = 0;
	}

	public QueryResponse(String resultCode, String resultDescription, int totalItems) {
		super();
		this.resultCode = resultCode;
		this.resultDescription = resultDescription;
		this.totalItems = totalItems;
	}

	public QueryResponse(int totalItems) {
		super();
		this.resultCode = "000";
		this.resultDescription = "OK";
		this.totalItems = totalItems;
	}

	public void setException(Exception e) {
		this.totalItems = 0;
		if (e instanceof ModelException) {
			setModelException((ModelException) e);
		} else {
			setGenericException((Exception) e);
		}
	}

	private void setModelException(ModelException e) {
		this.resultCode = e.getExceptionCode();
		this.resultDescription = e.getMessage();
	}

	private void setGenericException(Exception e) {
		this.resultCode = ModelException.GENERIC_EXCEPTION_CODE;
		String message = (e.getCause() != null ? e.getCause().getMessage() : e.getMessage());
		String stackTrace = Arrays.toString(e.getStackTrace());
		this.resultDescription = String.format("%s%n%s", message, stackTrace);
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultDescription() {
		return resultDescription;
	}

	public void setResultDescription(String resultDescription) {
		this.resultDescription = resultDescription;
	}

	public int getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

}
