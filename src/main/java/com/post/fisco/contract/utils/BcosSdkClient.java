package com.post.fisco.contract.utils;

import lombok.extern.slf4j.Slf4j;
import org.fisco.bcos.sdk.BcosSDK;
import org.fisco.bcos.sdk.client.Client;
import org.fisco.bcos.sdk.crypto.keypair.CryptoKeyPair;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * bcosSdk客户端
 */
@Slf4j
public class BcosSdkClient {

    public static Client client;
    public static CryptoKeyPair cryptoKeyPair;


    public static Client getClient() {
        if (client == null) {
            try {
                ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
                BcosSDK bcosSDK = context.getBean(BcosSDK.class);
                client = bcosSDK.getClient(1);
                cryptoKeyPair = client.getCryptoSuite().createKeyPair();
//            client.getCryptoSuite().setCryptoKeyPair(cryptoKeyPair);
                log.info("=》连接Bcos客户端:" + cryptoKeyPair.getAddress());
            } catch (BeansException e) {
                log.error("=》连接Bcos客户端异常",e);
                e.printStackTrace();
            }
        }
        return client;
    }
}
