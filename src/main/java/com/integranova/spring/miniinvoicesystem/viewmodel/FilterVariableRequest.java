package com.integranova.spring.miniinvoicesystem.viewmodel;

public class FilterVariableRequest {

	private String name;

	private Object value;

	public FilterVariableRequest() {
		this.name = "";
		this.value = null;
	}

	public FilterVariableRequest(String name, Object value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}
