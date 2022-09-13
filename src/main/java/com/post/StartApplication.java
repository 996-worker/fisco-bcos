
package com.post;

import com.post.config.SystemConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan("com.post.aspect")
@MapperScan("com.post.dao")
@SpringBootApplication
public class StartApplication implements CommandLineRunner, DisposableBean {
	@Autowired
	SystemConfig systemConfig;

	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("[" + systemConfig.serviceName + "]启动成功");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("[" + systemConfig.serviceName + "]已停止服务");
	}
}
