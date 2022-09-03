package com.post.init;

import lombok.extern.slf4j.Slf4j;
import org.fisco.bcos.sdk.BcosSDK;
import org.fisco.bcos.sdk.client.Client;
import org.fisco.bcos.sdk.crypto.keypair.CryptoKeyPair;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.PostConstruct;

@Slf4j
public class BcosClient {
	public static Client client;

	public static Client getClient() {
		if (client == null) {
			log.info("=>BcosClient初始化");
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
			BcosSDK bcosSDK = context.getBean(BcosSDK.class);
			client = bcosSDK.getClient(1);
			CryptoKeyPair cryptoKeyPair = client.getCryptoSuite().createKeyPair();
			client.getCryptoSuite().setCryptoKeyPair(cryptoKeyPair);
			log.info("=>BcosClient初始化成功：" + cryptoKeyPair.getAddress());
		}

		return client;

	}

}