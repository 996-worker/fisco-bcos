package com.post.scheduled;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.post.utils.CtxUtils;

import javax.annotation.PostConstruct;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @Title: 计划任务
 * @Description: 1.数据同步任务
 * @author: 雷大鹏
 * @date: 2020-05-10 10:25:48
 */
@Service
public class ScheduledMainService {

	ScheduledThreadPoolExecutor scheduledPool;

	@PostConstruct
	public void start() {
//		System.out.println("====================定时任务启动");
//		scheduledPool = new ScheduledThreadPoolExecutor(2);
//		scheduledPool.scheduleAtFixedRate(new Thread(new Runnable() {
//			@Override
//			public void run() {
//				AsynSendService.instance().sync();
//			}
//		}, "同步任务"), 5, 10, TimeUnit.SECONDS);
//
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				System.out.println("====================》kafka接收线程");
//				try {
//					Thread.sleep(5000L);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				KafkaReceiver.instance().receiveData();
//			}
//		}).start();
	}

}
