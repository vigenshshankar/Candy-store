package com.cg.onlinesweetmart.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {

	@NotBlank(message = "Username or Email is required")
	private String usernameOrEmail;
	
	@NotBlank(message = "Password is required")
	private String password;
}