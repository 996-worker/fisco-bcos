package com.post.contract.idc.service;

import com.post.contract.idc.IDCNoticeController;
import com.post.init.BcosClient;

import lombok.extern.slf4j.Slf4j;

import org.fisco.bcos.sdk.client.Client;
import org.fisco.bcos.sdk.crypto.keypair.CryptoKeyPair;
import org.fisco.bcos.sdk.eventsub.EventCallback;
import org.fisco.bcos.sdk.model.EventLog;
import org.fisco.bcos.sdk.transaction.model.exception.ContractException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
@Service
public class IdcNoticeService {
	public static String address = null;

	public static String getAddress() {
		if (address == null) {
//			address = "0x22a1212d13f764a86e5974beeed84b8714799e3f";
			Client client = BcosClient.getClient();
			CryptoKeyPair credential = client.getCryptoSuite().createKeyPair();
			try {
				address = IDCNoticeController.deploy(client, credential).getContractAddress();
				System.out.println("通知部署成功,地址:" + address);
			} catch (ContractException e) {
				e.printStackTrace();
			}
			;
		}
		return address;
	}

//	@PostConstruct
	public void init() {
		Client client = BcosClient.getClient();
		CryptoKeyPair credential = client.getCryptoSuite().createKeyPair();

		IDCNoticeController notice = IDCNoticeController.load(getAddress(), client, credential);
		System.out.println("=》通知新增-观察者注册");
		notice.subscribeIDCNoticeSavedEvent(new EventCallback() {
			@Override
			public void onReceiveLog(int i, List<EventLog> list) {
				IdcNoticeService.log.info("新增通知,i=[" + i + "],list[" + (list == null) + "]");
				if (list != null) {
					for (EventLog log : list) {
						System.out.println("新增通知：" + log.getData());
						IdcNoticeService.log.info("新增通知：" + log.getData());
					}
				}

			}
		});

	}
}
