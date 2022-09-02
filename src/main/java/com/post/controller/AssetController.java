
package com.post.controller;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.List;

import org.fisco.bcos.sdk.BcosSDK;
import org.fisco.bcos.sdk.abi.datatypes.generated.tuples.generated.Tuple2;
import org.fisco.bcos.sdk.client.Client;
import org.fisco.bcos.sdk.crypto.keypair.CryptoKeyPair;
import org.fisco.bcos.sdk.model.TransactionReceipt;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.post.contract.Asset;

@RestController
@CrossOrigin(allowCredentials = "true")
@RequestMapping(value = "/api/asset")
@Slf4j
public class AssetController extends BaseController {

	private BcosSDK bcosSDK;
	private Client client;
	private CryptoKeyPair cryptoKeyPair;

	private String address;

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
			Asset asset = Asset.deploy(client, cryptoKeyPair);
			System.out.println(" deploy Asset success, contract address is " + asset.getContractAddress());
			this.address = asset.getContractAddress();
			log.info("=》部署合约[asset]成功,地址为" + this.address);
		} catch (Exception e) {
			System.out.println(" deploy Asset contract failed, error message is  " + e.getMessage());
		}
	}

	@RequestMapping("deploy")
	public String deploy1() {
//		kafkaSender.send(message);
		deploy();
		return this.address;
	}

	@RequestMapping("register")
	public String register(String account, String amount) {
		try {
			String contractAddress = this.address;
			log.info("账户注册-合约地址:" + contractAddress);

			Asset asset = Asset.load(contractAddress, client, cryptoKeyPair);
			TransactionReceipt receipt = asset.register(account, new BigInteger(amount));
			List<Asset.RegisterEventEventResponse> response = asset.getRegisterEventEvents(receipt);
			if (!response.isEmpty()) {
				if (response.get(0).ret.toString().equals("0")) {
					System.out.printf(" register asset account success => asset: %s, value: %s \n", account, amount);
					return "ok";
				} else {
					System.out.printf(" register asset account failed, ret code is %s \n",
							response.get(0).ret.toString());
				}
			} else {
				System.out.println(" event log not found, maybe transaction not exec. ");
			}
		} catch (Exception e) {
			log.error("创建账户失败:" + e.getMessage());
			return "error";
		}
		return "fail";
	}

	@RequestMapping("query")
	public String queryAssetAmount(String assetAccount) {
		try {
			String contractAddress = this.address;
			Asset asset = Asset.load(contractAddress, client, cryptoKeyPair);
			Tuple2<BigInteger, BigInteger> result = asset.select(assetAccount);
			if (result.getValue1().toString().equals("0")) {
				return result.getValue2() + "";
			} else {
				return "无效账户:" + assetAccount;
			}
		} catch (Exception e) {
			log.error(" queryAssetAmount exception, error message is {}", e.getMessage());
			return "系统异常,账户:" + assetAccount;

		}
	}

}
