package com.post.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.post.utils.AddressUtils;
import com.post.utils.JsonUtils;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Aspect
@Component
@Slf4j
public class RequestAspect {

	private ThreadLocal<Map> tlocal = new ThreadLocal<Map>();

	@Pointcut("execution(public * com.post.controller..*.*(..))")
	public void webRequestLog() {
	}

	@Before("webRequestLog()")
	public void doBefore(JoinPoint joinPoint) {
		long beginTime = System.currentTimeMillis();
		try {

			// 统计请求相关信息
			ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpServletRequest request = attributes.getRequest();
			// 访问url
			String uri = request.getRequestURI();
			// 访问者ip
			String remoteAddr = AddressUtils.getIpAddr(request);
			// 访问方式
			String method = request.getMethod();
			String params = "";
			log.info("==========>>>>request,访问者:" + remoteAddr + ",getHeader地址:" + request.getHeader("Content-Type"));
			// 获取输入参数
			if (request.getHeader("Content-Type") != null
					&& request.getHeader("Content-Type").indexOf("multipart/form-data") != -1) {
				params = "文件上传";
			} else if ("POST".equals(method)) {
				params = JsonUtils.toJson(joinPoint.getArgs()).toString().replaceAll("\\\\n", "").replaceAll(" ", "");
			} else {
				params = request.getQueryString();
			}
			log.info("==========>>>>request,访问者:" + remoteAddr + ",接口地址:" + uri + ",传入参数:" + params);

//			SysRequestMapping requestMapping = getRequestMapping().get(uri);
//			try {
//
//				if (requestMapping != null) {
//					log.info("操作日志记录");
//					SysRequestHistory history = new SysRequestHistory();
//					history.setThreadId(Thread.currentThread().getName());
//					history.setRequestCname(getRequestMapping().get(uri).getCname());
//					history.setRequestDate(new Date());
//					history.setRequestMapping(uri);
//					history.setUserIp(remoteAddr);
//					if (params.indexOf("token") != -1) {
//
//						for (String str : params.split("&")) {
//							if (str.startsWith("token=")) {
//								String token = str.replace("token=", "");
//								history.setToken(token);
//								history.setUserName(URLDecoder.decode(TokenUtils.getUserNameByToken(token)));
//								history.setUserRoleName(TokenUtils.getRoleCodeByToken(token));
//
//							}
//						}
//					}
//					sysRequestHistoryMapper.insert(history);
//
//				}
//			} catch (Exception e) {
//				log.error("***操作日志插入失败doBefore()***", e);
//				e.printStackTrace();
//			}
			// 讲统计信息放入缓存
			Map optLog = new HashMap();
			optLog.put("request_beginTime", beginTime);
			tlocal.set(optLog);
		} catch (Exception e) {
			log.error("***请求报文分析失败doBefore()***", e);
		}
	}

	@AfterReturning(returning = "result", pointcut = "webRequestLog()")
	public void doAfterReturning(Object result) {
		Map optLog = tlocal.get();
		try {
			long beginTime = (long) optLog.get("request_beginTime");
			long duration = System.currentTimeMillis() - beginTime;

			log.info("<<<<==========response,交易耗时:[" + (duration) + "],返回报文[" + JsonUtils.toJson(result) + "]");
		} catch (

		Exception e) {
			log.error("***响应报文分析失败doAfterReturning()***", e);
		}
		optLog = null;
	}

	@AfterThrowing(pointcut = "webRequestLog()", throwing = "e")
	public void handleThrowing(Exception e) {
		Map optLog = tlocal.get();
		try {
			long beginTime = (long) optLog.get("request_beginTime");
			long duration = System.currentTimeMillis() - beginTime;
			log.info("<<<<==========response,交易耗时:[" + (duration) + "]");
		} catch (Exception ee) {
			log.error("***响应报文分析失败doAfterReturning()***", ee);
		}
		optLog = null;
	}

}