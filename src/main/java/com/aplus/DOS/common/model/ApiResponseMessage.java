package com.aplus.DOS.common.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@ToString
public class ApiResponseMessage {
    private String status;
    private String message;
    private String errorMessage;
    private String errorCode;
    
	public ApiResponseMessage(String status, String message, String errorMessage, String errorCode) {
		this.status = status;
		this.message = message;
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}
    
}
