package com.post.utils.generator;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class SqlToJavaCodeUtils {
	public static void main(String[] args) {
		SqlToJavaCodeUtils generator = new SqlToJavaCodeUtils();
		System.out.println(System.getProperty("user.dir"));
		System.out.println(generator.getClass().getResource("/").getPath());
		generator.run();
	}

	public void run() {
		try {
			InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("generatorConfig.xml");
			List<String> warnings = new ArrayList<>();
			ConfigurationParser parser = new ConfigurationParser(warnings);
			Configuration config = parser.parseConfiguration(resourceAsStream);
			DefaultShellCallback callback = new DefaultShellCallback(true);
			MyBatisGenerator generator = new MyBatisGenerator(config, callback, warnings);
			generator.generate(null);
			for (String warning : warnings) {
				System.err.println(">" + warning);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("====================执行结束====================");
	}
}
