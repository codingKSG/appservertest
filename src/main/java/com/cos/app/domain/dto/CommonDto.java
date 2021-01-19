package com.cos.app.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommonDto<T> {
	private int statNum;
	private T data;

	public CommonDto(int statNum, T data) {
		super();
		this.statNum = statNum;
		this.data = data;
	}

	public CommonDto(int statNum) {
		super();
		this.statNum = statNum;
	}

}
