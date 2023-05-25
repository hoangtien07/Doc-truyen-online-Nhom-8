package com.web.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.entity.LoaiTruyen;
import com.web.entity.Truyen;

@Repository
@Transactional
public class LoaiTruyenDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<LoaiTruyen> findAll(){
		List<LoaiTruyen> list = null;
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("From LoaiTruyen");
		list = query.list();
		return list;
	}
	
	public LoaiTruyen findById(Long id){
		LoaiTruyen truyen = null;
		Session session = sessionFactory.getCurrentSession();
		truyen = (LoaiTruyen) session.get(LoaiTruyen.class, id);
		return truyen;
	}
}
