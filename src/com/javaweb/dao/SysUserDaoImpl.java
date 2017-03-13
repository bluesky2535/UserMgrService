package com.javaweb.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.javaweb.po.SysUser;

@Repository
public class SysUserDaoImpl implements SysUserDao {
	@Resource
	private SessionFactory sessionFactory;

	public Session getsession() {
		return sessionFactory.getCurrentSession();
	}

	public SysUser findUserbyNameAndPassword(SysUser sysUser) {
		SysUser s = (SysUser) getsession()
				.createQuery(
						"From SysUser s where s.vsuname=:suname  and s.vpassword=:vpassword")
				.setString("suname", sysUser.getVsuname())
				.setString("vpassword", sysUser.getVpassword()).uniqueResult();
		return s;
	}

	/**
	 * 查出总共的sysUser数
	 */
	@Override
	public int selectCount() {

		return ((Number) getsession().createQuery(
				"select count(*) from SysUser").uniqueResult()).intValue();
	}

	/**
	 * 分页的SysUser
	 */
	public List<SysUser> queryPage(int page, int rows) {

		/*
		 * if (rows : 15 ){ rownum : pagenum*15 rn:(pagenum-1)*15+1 }
		 */
		int rownum = page * rows;
		int rn = (page - 1) * rows + 1;
		String sql = "select  * FROM ( SELECT a.*,  ROWNUM rn  FROM (SELECT * FROM th_sysuser) a WHERE ROWNUM <=:rownum) WHERE rn >= :rn";
		@SuppressWarnings("unchecked")
		List<SysUser> sysUsers = getsession().createSQLQuery(sql)
				.addEntity(SysUser.class).setInteger("rownum", rownum)
				.setInteger("rn", rn).list();
		return sysUsers;
	}

	@Override
	public int deletebyVsuids(List<Integer> vsuidslist) {
		int s = getsession()
				.createQuery("delete from SysUser where vsuid in(:vsuids)")
				.setParameterList("vsuids", vsuidslist).executeUpdate();
		return s;
	}

	/**
	 * 增加sysUser
	 */
	@Override
	public void add(SysUser sysUser) {
		getsession().save(sysUser);

	}

	/**
	 * 更新sysUser
	 */
	@Override
	public void update(SysUser sysUser) throws Exception {
		getsession().update(sysUser);
	}

	/**
	 * 根据名称查出系统用户
	 */
	@Override
	public SysUser findUserbyName(SysUser sysUser) throws Exception {
		SysUser s = (SysUser) getsession()
				.createQuery("From SysUser s  where s.vsuname=:vsname")
				.setString("vsname", sysUser.getVsuname()).uniqueResult();
		return s;
	}

	@Override
	public SysUser findSysUserbyID(SysUser sysUser)throws Exception {
		SysUser s = (SysUser) getsession()
				.createQuery("from SysUser s where s.vsuid=:vsuid")
				.setInteger("vsuid", sysUser.getVsuid()).uniqueResult();
		return s;
	}

}
