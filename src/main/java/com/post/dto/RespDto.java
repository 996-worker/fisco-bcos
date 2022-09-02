package com.post.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * 
 * @Title: ResponseDto.java
 * @Description: 微服务-响应报文
 * @author: 雷大鹏
 * @date: 2020-06-22 12:38:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespDto<T> {
	// 交易状态
	String status;
	// 响应吗
	String respCode;
	// 响应码说明
	String respCodeDesc;
	// 响应报文
	T data;
}
