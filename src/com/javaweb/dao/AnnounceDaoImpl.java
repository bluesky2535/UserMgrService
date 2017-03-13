package com.javaweb.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.javaweb.po.Announce;

@Repository
public class AnnounceDaoImpl implements AnnounceDao {

	@Resource
	private SessionFactory sessionFactory;

	public Session getsession() {
		return sessionFactory.getCurrentSession();
	}

	public void add(Announce announce) {
		getsession().save(announce);
	}

	public void delete(Announce announce) {
		getsession().delete(announce);
	}

	public void update(Announce announce) {
		getsession().update(announce);
	}

	public Announce queryByID(Announce announce) {
		Announce a = (Announce) getsession()
				.createQuery("from Announce where vanid=:vanid")
				.setInteger("vanid", announce.getVanid()).uniqueResult();
		return a;
	}

	public List<Announce> queryAll() {
		@SuppressWarnings("unchecked")
		List<Announce> announces = getsession().createQuery("from Announce")
				.list();
		return announces;
	}

	public int deletebyVanids(List<Integer> vanidslist) {
		int s = getsession()
				.createQuery("delete from Announce where vanid in(:vanids)")
				.setParameterList("vanids", vanidslist).executeUpdate();
		return s;
	}

	@Override
	public List<Announce> queryByModiferID(int vsuid) {
		List<Announce> announces = getsession()
				.createQuery("From Announce a where  a.vmodifier.vsuid=:vsuid")
				.setInteger("vsuid", vsuid).list();
		return announces;
	}

	@Override
	public List<Announce> querybyGrade(int grade) {

		List<Announce> announces = getsession().createQuery(
				"From Announce a where  a.grade=:grade").setInteger("grade", grade).list();
		
		return announces;
	}

}
