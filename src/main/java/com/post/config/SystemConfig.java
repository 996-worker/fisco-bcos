
package com.post.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Title: 系统配置
 * @Description: TODO(描述)
 * @author: 雷大鹏
 * @date: 2020-05-10 10:12:19
 */
@Service
public class SystemConfig {
	@Value("${server.name:null}")
	public String serviceName = "";

}
