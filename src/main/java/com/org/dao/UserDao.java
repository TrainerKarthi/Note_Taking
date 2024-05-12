package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.org.dto.User;

public class UserDao {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("karthik");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	public void saveAndUpdateUser(User user) {
		
		et.begin();
		em.merge(user);
		et.commit();
	}

	public User loginUser(String email, String password) {
		Query query = em.createQuery("SELECT u from User u where u.email=?1 and u.password=?2");
		
		query.setParameter(1, email);
		query.setParameter(2, password);
		List<User> list = query.getResultList();
		
		if(list.isEmpty())
			return null;
		
		return list.get(0);
	}

}
