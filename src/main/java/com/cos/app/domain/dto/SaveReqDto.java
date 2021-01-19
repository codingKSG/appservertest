package com.cos.app.domain.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import lombok.Data;

@Data
public class SaveReqDto {
	
	@NotBlank
	private String title;

	@Positive
	private double rating;
}
