package com.javaweb.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.javaweb.po.Advertisement;

@Repository
public class AdvertisementDaoImpl implements AdvertisementDao {

	@Resource
	private SessionFactory sessionFactory;

	public Session getsession() {
		return sessionFactory.getCurrentSession();
	}

	public void delete(Advertisement advertisement) {
		getsession().delete(advertisement);
	}

	public void add(Advertisement advertisement) {
		getsession().save(advertisement);
	}

	public void update(Advertisement advertisement) {
		getsession().update(advertisement);
	}

	public Advertisement queryByID(Advertisement advertisement) {
		Advertisement a = (Advertisement) getsession()
				.createQuery("from Advertisement where vadid=:vadid")
				.setInteger("vadid", advertisement.getVadid()).uniqueResult();
		return a;
	}

	public List<Advertisement> queryall() {

		@SuppressWarnings("unchecked")
		List<Advertisement> advertisements = getsession().createQuery(
				"From Advertisement").list();
		return advertisements;
	}

	public int deletebyVadids(List<Integer> vadidslist) {
		int s = getsession()
				.createQuery("delete from Advertisement where vadid in(:vadids)")
				.setParameterList("vadids", vadidslist).executeUpdate();
		return s;
	}

	@Override
	public List<Advertisement> queryByModiferID(int vsuid) {
		List<Advertisement> advertisements = getsession().createQuery(
				"From Advertisement a where  a.modifier.vsuid=:vsuid").setInteger("vsuid", vsuid).list();
		return advertisements;
	}


}
