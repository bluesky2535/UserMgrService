package com.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.javaweb.po.Advertisement;
import com.javaweb.po.SysUser;

public class Test {

	@org.junit.Test
	public void testFastJson() {

		SysUser s = new SysUser();
		s.setLastvisittime(new Date());
		List<Advertisement> as = new ArrayList<Advertisement>();
		Advertisement a=new Advertisement(1);
		Advertisement b=new Advertisement(1);
		Advertisement c=new Advertisement(1);
		as.add(a);
		as.add(b);
		as.add(c);
		String js = JSONObject.toJSONString(as);
		System.out.println(js);
	}
}
