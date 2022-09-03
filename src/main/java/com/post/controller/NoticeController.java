
package com.post.controller;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.Soundbank;

import org.fisco.bcos.sdk.BcosSDK;
import org.fisco.bcos.sdk.abi.ABICodec;
import org.fisco.bcos.sdk.abi.ABICodecException;
import org.fisco.bcos.sdk.abi.datatypes.generated.tuples.generated.Tuple2;
import org.fisco.bcos.sdk.client.Client;
import org.fisco.bcos.sdk.crypto.keypair.CryptoKeyPair;
import org.fisco.bcos.sdk.eventsub.EventCallback;
import org.fisco.bcos.sdk.eventsub.EventLogParams;
import org.fisco.bcos.sdk.model.EventLog;
import org.fisco.bcos.sdk.model.TransactionReceipt;
import org.fisco.bcos.sdk.transaction.model.exception.ContractException;
import org.fisco.bcos.sdk.transaction.tools.JsonUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.post.contract.Asset;
import com.post.contract.idc.IDCNoticeController;
import com.post.contract.idc.IDCNoticeController.IDCNoticeSavedEventResponse;
import com.post.utils.StringUtils;

@RestController
@CrossOrigin(allowCredentials = "true")
@RequestMapping(value = "/api/test")
@Slf4j
public class NoticeController extends BaseController {

	private BcosSDK bcosSDK;
	private Client client;
	private CryptoKeyPair cryptoKeyPair;

	private String address;
	byte[] seriesNo = "12345678901234567890123456789012".getBytes();

	public void initialize() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		bcosSDK = context.getBean(BcosSDK.class);
		client = bcosSDK.getClient(1);
		cryptoKeyPair = client.getCryptoSuite().createKeyPair();
		client.getCryptoSuite().setCryptoKeyPair(cryptoKeyPair);
		log.info("创建控制台连接:" + cryptoKeyPair.getAddress());
	}

	public void deploy() {
		try {
			initialize();
			log.info("=》部署合约[asset]");
			IDCNoticeController notice = IDCNoticeController.deploy(client, cryptoKeyPair);
			System.out.println(" deploy notice success, contract address is " + notice.getContractAddress());
			this.address = notice.getContractAddress();
			log.info("=》部署合约[notice]成功,地址为" + this.address);
		} catch (Exception e) {
			System.out.println(" deploy notice contract failed, error message is  " + e.getMessage());
		}
	}

	@RequestMapping("deploy")
	public String deploy1() {
//		kafkaSender.send(message);
		deploy();
		return this.address;
	}

	@RequestMapping("sub")
	public void sub() {
		String contractAddress = this.address;
		log.info("通知-合约地址:" + contractAddress);

		IDCNoticeController notice = IDCNoticeController.load(contractAddress, client, cryptoKeyPair);

		EventLogParams params = new EventLogParams();

		notice.subscribeIDCNoticeSavedEvent(new EventCallback() {

			@Override
			public void onReceiveLog(int status, List<EventLog> logs) {
				System.out.println("接收通知" + status);
				if (logs != null) {
					for (EventLog log : logs) {
						try {
							List<Object> list = new ABICodec(client.getCryptoSuite()).decodeEvent(notice.ABI,
									notice.IDCNOTICESAVED_EVENT.getName(), log);

							for (Object str : list) {
								String seriesNo_ = NoticeController
										.hexStringToString(str.toString().replaceAll("0x", ""));

								System.out.println("通知流水号:" + seriesNo_);
								try {
									System.out.println("通知内容:" + notice.geIDCNotice(seriesNo_.getBytes()));
								} catch (ContractException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}

						} catch (ABICodecException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("消息内容:" + log.getData());
						System.out.println(JsonUtils.toJson(log));
					}
				}

			}
		});

	}

	@RequestMapping("send")
	public String register(String msg) {
		String contractAddress = this.address;
		log.info("通知-合约地址:" + contractAddress);

		IDCNoticeController notice = IDCNoticeController.load(contractAddress, client, cryptoKeyPair);

		BigInteger plannedStartTime = new BigInteger("20220903020300");
		BigInteger plannedEndTime = new BigInteger("20220903020300");
		String contentJson = msg;
		;

		String seriesNo_ = StringUtils.fillRight(StringUtils.getPrimaryKey(), 32, "0");

//		String seriesNo_ = StringUtils.fillRight(NoticeController.convertStringToHex(StringUtils.getPrimaryKey()), 32,
//				"0");
		System.out.println("流水号:" + seriesNo_);
		TransactionReceipt receipt = notice.createIDCNotice(seriesNo_.getBytes(), plannedStartTime, plannedEndTime,
				contentJson);

		List<IDCNoticeSavedEventResponse> list = notice.getIDCNoticeSavedEvents(receipt);
		return "ok";
	}

	@RequestMapping("get")
	public String get(String seriesNo_) {
		String contractAddress = this.address;
		log.info("通知-合约地址:" + contractAddress);

		IDCNoticeController notice = IDCNoticeController.load(contractAddress, client, cryptoKeyPair);
		try {
			return notice.geIDCNotice(seriesNo_.getBytes());
		} catch (ContractException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}

	public static String stringToHexString(String s) {
		String str = "";
		for (int i = 0; i < s.length(); i++) {
			int ch = s.charAt(i);
			String s4 = Integer.toHexString(ch);
			str = str + s4;
		}
		return str;
	}

	public static String hexStringToString(String s) {
		if (s == null || s.equals("")) {
			return null;
		}
		s = s.replace(" ", "");
		byte[] baKeyword = new byte[s.length() / 2];
		for (int i = 0; i < baKeyword.length; i++) {
			try {
				baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			s = new String(baKeyword, "gbk");
			new String();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return s;
	}

	private static String convertStringToHex(String str) {
		StringBuilder stringBuilder = new StringBuilder();

		char[] charArray = str.toCharArray();

		for (char c : charArray) {
			String charToHex = Integer.toHexString(c);
			stringBuilder.append(charToHex);
		}

		System.out.println("Converted Hex from String: " + stringBuilder.toString());
		return stringBuilder.toString();
	}

	public static void main(String[] args) {

		String pk = StringUtils.getPrimaryKey();
		System.out.println("pk:" + pk);

		String hex = NoticeController.convertStringToHex(pk);
		System.out.println("hex:" + hex);

		String seriesNo_ = StringUtils.fillRight(hex, 32, "0");
		System.out.println("seriesNo_:" + seriesNo_);
		System.out.println("length:" + seriesNo_.length());
		//
		System.out.println("string" + NoticeController
				.hexStringToString("0acc86875b2ea24bebeb881926cc83ebc23cc350014c536f914ab5a341f157cb"));
	}
}
