package org.apfk.CineBackEnd.exceptions;

import lombok.Getter;

@Getter
public enum ErrorEnum {
	ENTITY_NOT_FOUND("error.entity-not-found"),
	VALIDATION_FAILURE("error.validation");
	
	private String key;
	
	private ErrorEnum(String key) {
		this.key=key;
	}
}
