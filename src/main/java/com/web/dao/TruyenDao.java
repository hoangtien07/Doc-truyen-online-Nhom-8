package com.web.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.entity.Truyen;


@Repository
@Transactional
public class TruyenDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void save(Truyen truyen) {
		Session session = sessionFactory.getCurrentSession();
		session.save(truyen);
	}
	public void update(Truyen truyen) {
		Session session = sessionFactory.getCurrentSession();
		session.update(truyen);
	}
	
	public List<Truyen> findAll(){
		List<Truyen> list = null;
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("From Truyen");
		list = query.list();
		return list;
	}
	
	public List<Truyen> findByName(String name){
		List<Truyen> list = null;
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select t From Truyen t where t.ten = :tens");
		query.setParameter("tens", name);
		list = query.list();
		return list;
	}
	
	public Set<Truyen> findByLoaiTruyen(Long id){
		List<Truyen> list = null;
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select t From Truyen t inner join t.loaiTruyen l where l.id = :ids");
		query.setParameter("ids", id);
		list = query.list();
		Set<Truyen> set = new HashSet<Truyen>(list);
		return set;
	}
	
	public Set<Truyen> search(String param){
		List<Truyen> list = null;
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select t From Truyen t where t.ten like :param or t.tenTap like :param");
		query.setParameter("param", "%"+param+"%");
		list = query.list();
		Set<Truyen> set = new HashSet<Truyen>(list);
		return set;
	}
	
	public Set<Truyen> findAllSet(){
		List<Truyen> list = null;
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("From Truyen");
		list = query.list();
		Set<Truyen> set = new HashSet<Truyen>(list);
		return set;
	}
	
	public Truyen findById(Long id){
		Truyen truyen = null;
		Session session = sessionFactory.getCurrentSession();
		truyen = (Truyen) session.get(Truyen.class, id);
		return truyen;
	}
	
	public void delete(Truyen truyen2) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(truyen2);
	}
}
