package com.cg.onlinesweetmart.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SweetMartAPIException extends RuntimeException{

	private HttpStatus status;
	private String message;
}
