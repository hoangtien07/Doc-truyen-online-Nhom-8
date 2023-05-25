package com.web.dao;

import com.web.dto.UserInfo;
import com.web.entity.Account;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserInfoDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public UserInfoDAO() {

    }

    public UserInfo findUserInfo(String userName) {
        String sql = "select a from Account a where a.username = :username and a.actived = :active";

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery(sql);
        query.setParameter("username", userName);
        query.setParameter("active", 1);
        Account a = (Account) query.uniqueResult();
        System.out.println("account-----: "+a);
        UserInfo u = new UserInfo(a.getUsername(), a.getPassword());
        return u;
    }

    public List<String> getUserRoles(String userName) {
        String sql = "select u.userRole from UserRole u inner join u.account where u.account.username = :username ";

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery(sql);
        query.setParameter("username", userName);

        List<String> roles = query.list();
        System.out.println(roles);

        return roles;
    }
}
