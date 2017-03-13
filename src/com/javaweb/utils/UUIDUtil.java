package com.javaweb.utils;

import java.util.UUID;


public class UUIDUtil {
	/**
	 * 获得随机的字符串
	 * @return
	 */
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
	
}
