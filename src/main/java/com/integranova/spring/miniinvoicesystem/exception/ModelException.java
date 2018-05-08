package com.integranova.spring.miniinvoicesystem.exception;

import java.util.ArrayList;
import java.util.List;

public class ModelException extends Exception {

	private static final long serialVersionUID = 1L;

	public static final String GENERIC_EXCEPTION_CODE = "999";

	private final String exceptionCode;

	private final String exceptionMessageId;

	private final List<String> exceptionMessageParts;

	public ModelException() {
		super();
		this.exceptionCode = GENERIC_EXCEPTION_CODE;
		this.exceptionMessageId = "";
		this.exceptionMessageParts = new ArrayList<>();
	}

	public ModelException(String message) {
		super(message);
		this.exceptionCode = GENERIC_EXCEPTION_CODE;
		this.exceptionMessageId = "";
		this.exceptionMessageParts = new ArrayList<>();
	}

	public ModelException(String message, Throwable cause) {
		super(message, cause);
		this.exceptionCode = GENERIC_EXCEPTION_CODE;
		this.exceptionMessageId = "";
		this.exceptionMessageParts = new ArrayList<>();
	}

	public ModelException(String code, String message) {
		super(message);
		this.exceptionCode = code;
		this.exceptionMessageId = "";
		this.exceptionMessageParts = new ArrayList<>();
	}

	public ModelException(String code, String message, Throwable cause) {
		super(message, cause);
		this.exceptionCode = code;
		this.exceptionMessageId = "";
		this.exceptionMessageParts = new ArrayList<>();
	}

	public ModelException(String exceptionCode, String message, String exceptionMessageId,
			List<String> exceptionMessageParts) {
		super(message);
		this.exceptionCode = exceptionCode;
		this.exceptionMessageId = exceptionMessageId;
		this.exceptionMessageParts = exceptionMessageParts;
	}

	public ModelException(String exceptionCode, String message, Throwable cause, String exceptionMessageId,
			List<String> exceptionMessageParts) {
		super(message, cause);
		this.exceptionCode = exceptionCode;
		this.exceptionMessageId = exceptionMessageId;
		this.exceptionMessageParts = exceptionMessageParts;
	}

	public String getExceptionCode() {
		return exceptionCode;
	}

	public String getExceptionMessageId() {
		return exceptionMessageId;
	}

	public List<String> getExceptionMessageParts() {
		return exceptionMessageParts;
	}
}
