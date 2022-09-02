package com.post.contract.idc.service;

import com.post.contract.idc.IDCNoticeController;
import com.post.init.BcosClient;
import org.fisco.bcos.sdk.client.Client;
import org.fisco.bcos.sdk.crypto.keypair.CryptoKeyPair;
import org.fisco.bcos.sdk.eventsub.EventCallback;
import org.fisco.bcos.sdk.model.EventLog;

import javax.annotation.PostConstruct;
import java.util.List;

public class IdcNoticeService {
    public static String address = null;

    public static String getAddress() {
        if (address == null) {
            address = "1231123";
        }
        return address;
    }

    @PostConstruct
    public void init() {
        Client client = BcosClient.getClient();
        CryptoKeyPair credential = client.getCryptoSuite().createKeyPair();
        IDCNoticeController notice = new IDCNoticeController(address, client, credential);
        notice.subscribeIDCNoticeSavedEvent(new EventCallback() {
            @Override
            public void onReceiveLog(int i, List<EventLog> list) {
                for (EventLog log : list) {
                    System.out.println("通知新增：" + log.getData());
                }
            }
        });
    }
}
