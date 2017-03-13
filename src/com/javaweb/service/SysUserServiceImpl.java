package com.javaweb.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.javaweb.dao.AdvertisementDao;
import com.javaweb.dao.AnnounceDao;
import com.javaweb.dao.SysUserDao;
import com.javaweb.po.Advertisement;
import com.javaweb.po.Announce;
import com.javaweb.po.SysUser;
import com.javaweb.po.SysUserVO;
import com.javaweb.utils.MD5Util;

@Service
@Transactional
public class SysUserServiceImpl implements SysUserService {

	@Resource
	private AdvertisementDao advertisementDao;
	@Resource
	private AnnounceDao announceDao;
	@Resource
	private SysUserDao sysUserDao;

	/**
	 * SysUser登录 返回0： 登录失败，用户名或密码错误。 1： 登录成功，用户登录成功
	 */
	public int login(SysUser sysUser) throws Exception {
		String md5password = MD5Util.MD5(sysUser.getVpassword());
		sysUser.setVpassword(md5password);
		SysUser s = sysUserDao.findUserbyNameAndPassword(sysUser);
		if (s == null) {
			return 0;
		}
		// 登录成功后，将该用户保存在Session 中
		ServletActionContext.getRequest().getSession()
				.setAttribute("sysUser", s);
		return 1;
	}

	/**
	 * 将SysUser转换为SysUserVo
	 */
	public String querypage(String page, String rows) throws Exception {
		int sysUserCount = sysUserDao.selectCount();
		List<SysUser> sysUsers = sysUserDao.queryPage(Integer.parseInt(page),
				Integer.parseInt(rows));
		List<SysUserVO> sysUserVOs = new ArrayList<SysUserVO>();
		for (SysUser SysUser : sysUsers) {

			SysUserVO sysUserVO = new SysUserVO();
			try {
				BeanUtils.copyProperties(sysUserVO, SysUser);
			} catch (Exception e) {
				e.printStackTrace();
			}
			sysUserVOs.add(sysUserVO);
		}
		String s = JSON.toJSONString(sysUserVOs);
		// 如果让easyUI可以显示总页数，需要格式为{"total"：25,"rows":"[{},{}]"}
		String sysUserjson = "{\"total\"" + ":" + sysUserCount + ",\"rows\":"
				+ s + "}";
		return sysUserjson;
	}

	/**
	 * 由于暂时还没找出hibernate的不能级联的问题，所以暂时使用最笨的方法
	 */
	@Override
	public int deletebyVsuids(String vsuids) throws Exception {
		List<Integer> vsuidslist = new ArrayList<Integer>();
		String[] vsuidss = vsuids.split(",");
		for (String vsuid : vsuidss) {
			vsuidslist.add(Integer.parseInt(vsuid));
			
			//删除该用户创建的所有广告
			List<Advertisement> advertisements = advertisementDao
					.queryByModiferID(Integer.parseInt(vsuid));
			if (advertisements != null) {
				for (Advertisement advertisement : advertisements) {
					advertisementDao.delete(advertisement);
				}
			}
			//删除该用户创建的所有公告
			List<Announce> announces = announceDao
					.queryByModiferID(Integer.parseInt(vsuid));
			if (announces != null) {
				for (Announce announce : announces) {
					announceDao.delete(announce);
				}
			}
		}
		int i = sysUserDao.deletebyVsuids(vsuidslist);
		return i;
	}

	/**
	 * 新增用户，并将密码加密
	 */
	@Override
	public String addSysUser(SysUser sysUser) throws Exception {
		SysUser s = sysUserDao.findUserbyName(sysUser);
		if (s != null) {
			return "N";// 如果不等于空,则不能注册
		}
		String vpassword = sysUser.getVpassword();
		String md5password = MD5Util.MD5(vpassword);
		sysUser.setVpassword(md5password);
		sysUserDao.add(sysUser);
		return "Y";
	}

	/**
	 * 修改sysUser
	 */
	@Override
	public void modify(SysUser sysUser) throws Exception {
		String password = sysUser.getVpassword();
		SysUser s = sysUserDao.findSysUserbyID(sysUser);
		s.setVpassword(MD5Util.MD5(password));
		sysUserDao.update(s);
	}

	@Override
	public SysUser findSysUserbyID(SysUser sysUser) throws Exception {
		SysUser s = sysUserDao.findSysUserbyID(sysUser);
		return s;
	}

}
