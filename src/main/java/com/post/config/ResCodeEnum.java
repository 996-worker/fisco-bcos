package com.post.config;

import lombok.Getter;
import lombok.Setter;

public enum ResCodeEnum {
	SUCCESS("SUCCESS"), ERROR("ERROR");

	@Setter
	@Getter
	private String code;

	ResCodeEnum(String code) {
		this.code = code;
	}

}
