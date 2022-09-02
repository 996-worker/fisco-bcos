
package com.post.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(allowCredentials = "true")
@RequestMapping(value = "/api/kafka")
@Slf4j
public class TestController extends BaseController {

	@RequestMapping("send")
	public String send(String topic, String key, String message) {
//		kafkaSender.send(message);
		return "ok";
	}

}
