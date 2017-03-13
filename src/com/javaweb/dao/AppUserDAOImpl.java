package com.javaweb.dao;

import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.javaweb.po.AppUser;

@Repository
public class AppUserDAOImpl implements AppUserDAO {
	@Resource
	private SessionFactory sessionFactory;

	public Session getsession() {
		return sessionFactory.getCurrentSession();
	}

	public void save(AppUser appUser) {
		getsession().save(appUser);
	}

	public void delete(AppUser appUser) {
	}

	public void update(AppUser appUser) {
		getsession().update(appUser);
	}

	/**
	 * 根据ID查出相应的appUSer
	 */
	public AppUser queryAppUserByID(int vauid) {
		String sql = "from AppUser a where a.vauid=:vauid";
		AppUser a = (AppUser) getsession().createQuery(sql)
				.setInteger("vauid", vauid).uniqueResult();
		return a;
	}

	/**
	 * 查询出appuser的记录数
	 */
	public int selectCount() {

		return ((Number) getsession().createQuery(
				"select count(*) from AppUser").uniqueResult()).intValue();
	}

	public List<AppUser> queryPage(int page, int rows) {

		/*
		 * if (rows : 15 ){ rownum : pagenum*15 rn:(pagenum-1)*15+1 }
		 */
		int rownum = page * rows;
		int rn = (page - 1) * rows + 1;
		String sql = "select  * FROM ( SELECT a.*,  ROWNUM rn  FROM (SELECT * FROM th_appuser) a WHERE ROWNUM <=:rownum) WHERE rn >= :rn";
		@SuppressWarnings("unchecked")
		List<AppUser> appusers = getsession().createSQLQuery(sql)
				.addEntity(AppUser.class).setInteger("rownum", rownum)
				.setInteger("rn", rn).list();
		return appusers;
	}

	public int deletebyVauids(List<Integer> vauidslist) {
		int s = getsession()
				.createQuery("delete from AppUser where vauid in(:vauids)")
				.setParameterList("vauids", vauidslist).executeUpdate();
		return s;
	}

	@Override
	public AppUser findUser(AppUser appUser) {
		AppUser au = (AppUser) getsession()
				.createQuery(
						"from AppUser  a where  a.vtel=:vtel  and a.vpassword=:vpassword")
				.setString("vtel", appUser.getVtel())
				.setString("vpassword", appUser.getVpassword()).uniqueResult();
		return au;
	}

	@Override
	public AppUser findUserbyVtel(AppUser appUser) throws Exception {
		AppUser a = (AppUser) getsession()
				.createQuery("from AppUser a  where  a.vtel=:vtel")
				.setString("vtel", appUser.getVtel()).uniqueResult();
		
		return a;
	}

}
