package com.web.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.entity.LoaiTruyen;
import com.web.entity.LuuTruyen;
import com.web.entity.Truyen;

@Repository
@Transactional
public class LuuTruyenDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<LuuTruyen> findByUser(Long userId){
		List<LuuTruyen> list = null;
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select l From LuuTruyen l inner join l.account a where a.id = :ids");
		query.setParameter("ids", userId);
		list = query.list();
		return list;
	}
	
	public LuuTruyen findById(Long id){
		LuuTruyen truyen = null;
		Session session = sessionFactory.getCurrentSession();
		truyen = (LuuTruyen) session.get(LuuTruyen.class, id);
		return truyen;
	}
	

	public void save(LuuTruyen luuTruyen) {
		Session session = sessionFactory.getCurrentSession();
		session.save(luuTruyen);
	}
	public void delete(LuuTruyen luuTruyen) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(luuTruyen);
	}
}
