package com.post.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @Description 网络地址工具类
 * @author 雷大鹏
 * @date 2020-07-07 11:38:11
 */
public class AddressUtils {
	
	/**
	 * ip地址正则
	 */
	public static String IpRegex="((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)";

	/**
	 * 
	 * @Description 获取主机名称
	 * @return
	 * @author 雷大鹏
	 * @date 2020-07-07 11:38:23
	 */
	public static String getHostName() {
		InetAddress addr;
		try {
			addr = InetAddress.getLocalHost();
			return addr.getHostName();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "无法获取主机信息";

	}

	/**
	 * 
	 * @Description 获取请求者ip
	 * @param request
	 * @return
	 * @author 雷大鹏
	 * @date 2020-08-06 12:01:39
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	
}
