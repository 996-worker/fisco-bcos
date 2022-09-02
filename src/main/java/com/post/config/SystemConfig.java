
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

	@Value("${spring.kafka.sync-topic.send-topic:null}")
	public String kafkaSendTopic = "";

	@Value("${spring.kafka.sync-topic.receive-topic:null}")
	public String kafkaReceiveTopic = "";

	@Value("${spring.kafka.consumer.group-id:null}")
	public String kafkaReceiveGroupId = "";

	@Value("${spring.kafka.consumer.auto-offset-reset:null}")
	public String kafkaReceiveAutoOffsetReset = "";
	// max.poll.records
	@Value("${spring.kafka.consumer.max-poll-records:null}")
	public String kafkaReceiveMaxPollRecords = "";

	@Value("${spring.kafka.consumer.session.timeout.ms:null}")
	public String kafkaReceiveSessionTimeoutMs = "";

	@Value("${spring.kafka.consumer.bootstrap-servers:null}")
	public String kafkaReceiveBootstrapServers = "";

	@Value("${spring.kafka.bootstrap-servers:null}")
	public String kafkaBootstrapServers = "";

	public String sendStatus = "待启动";
	public String receiveStatus = "待启动";

	// fetch.max.bytes

}
