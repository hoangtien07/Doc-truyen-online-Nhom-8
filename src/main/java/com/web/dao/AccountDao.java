package com.web.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.entity.Account;
import com.web.entity.UserRole;

@Repository
@Transactional
public class AccountDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Account save(Account account) {
		Session session = sessionFactory.getCurrentSession();
		session.save(account);
		return account;
	}
	
	public void saveRole(UserRole role) {
		Session session = sessionFactory.getCurrentSession();
		session.save(role);
	}
	public Account update(Account account) {
		Session session = sessionFactory.getCurrentSession();
		session.update(account);
		return account;
	}
	
	public Account findByActiveKey(String key) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select a from Account a where a.activationKey = :key");
		query.setParameter("key", key);
		Account account = null;
		try {
			account = (Account) query.uniqueResult();
		} catch (Exception e) {
			return null;
		}
		return account;
	}
	public Account findByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select a from Account a where a.username = :key");
		query.setParameter("key", username);
		Account account = null;
		try {
			account = (Account) query.uniqueResult();
		} catch (Exception e) {
			return null;
		}
		return account;
	}
	
	public Account findById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Account account = (Account) session.get(Account.class, id);
		return account;
	}
	
	public List<Account> findAll(){
		List<Account> list = null;
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Account");
		
		list = query.list();
		for(int i=0; i< list.size(); i++) {
			for(UserRole u : list.get(i).getUserRoles()) {
				if(u.getUserRole().equals("ADMIN")) {
					list.remove(i);
					--i;
					break;
				}
			}
		}
		return list;
	}
}
