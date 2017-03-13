package com.javaweb.webservice;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.javaweb.dao.AnnounceDao;
import com.javaweb.dao.AppUserDAO;
import com.javaweb.po.Announce;
import com.javaweb.po.AppUser;
import com.javaweb.utils.MD5Util;
import com.yonyou.um.json.JSONException;
import com.yonyou.um.json.JSONObject;

@Service
@Transactional
public class BasicServiceWSImpl implements BasicServiceWS {

	@Resource
	AppUserDAO appUserDAO;
	@Resource
	AnnounceDao announceDao;

	/**
	 * 反射机制,获取需要调用该类的方法，然后使用方法对象执行
	 */
	public String getResults(String transStr) {
		// JSONObject jsonObj = JSONObject.fromObject(transStr);
		JSONObject jsonObj;
		String methodName = null;
		String paramsStr = null;
		try {
			jsonObj = new JSONObject(transStr);

			methodName = jsonObj.getString("methodName");
			paramsStr = jsonObj.getString("paramsStr");
		} catch (JSONException e1) {
			e1.printStackTrace();
		}

		// 找寻方法
		Class clazz = this.getClass();
		Method method = null;
		try {
			method = clazz.getMethod(methodName, new Class[] { String.class });
			// public final java.lang.String
			// $Proxy58.testMethod(java.lang.String)
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

		if (method == null) {
			return "服务端找不到方法——" + methodName;
		}
		Object retObj = null;
		try {
			retObj = method.invoke(this, new Object[] { paramsStr });
		} catch (InvocationTargetException e) {
			Throwable bb = e.getTargetException();
			return bb.getMessage();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return retObj.toString();
	}

	/**
	 * 注册AppUser
	 * 
	 * @param str
	 * @return
	 */
	public String registAppuser(String str) {
		try {
			AppUser appUser = new AppUser();
			JSONObject jsonObject = new JSONObject(str);
			String vtel = jsonObject.getString("vtel");
			// 查询该手机号是否已经注册
			AppUser a = appUserDAO.findUserbyVtel(appUser);
			if (a != null) {
				return "N";// 用户已经注册
			}
			String vpassword = jsonObject.getString("vpassword");
			appUser.setVtel(vtel);
			appUser.setVpassword(MD5Util.MD5(vpassword));
			appUserDAO.save(appUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Y";// 用户注册成功
	}

	/**
	 * AppUser登录
	 * 
	 * @param str
	 * @return
	 */
	public String loginAppUser(String str) {
		JSONObject jsonObject;
		try {
			jsonObject = new JSONObject(str);
			// 解析出电话号和密码
			String vtel = jsonObject.getString("vtel");
			String vpassword = jsonObject.getString("vpassword");
			AppUser appUser = new AppUser();
			appUser.setVtel(vtel);
			// 将密码经过md5加密，如果和数据库匹配，就登录成功。
			appUser.setVpassword(MD5Util.MD5(vpassword));
			AppUser a = appUserDAO.findUser(appUser);
			if (a == null) {
				return "N";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Y";
	}

	/**
	 * 查出所有的广告 0为普通，1为重要
	 * 
	 * @return
	 */
	public String queryAnnounce(String str) {
		int i = Integer.parseInt(str);
		List<Announce> announces = null;
		if (i == 1 || i == 2) {
			announces = announceDao.querybyGrade(i);
		} else {
			announces = announceDao.queryAll();
		}
		String announceJson = (String) com.alibaba.fastjson.JSONObject
				.toJSONString(announces,
						SerializerFeature.DisableCircularReferenceDetect);
		return announceJson;
	}
}
