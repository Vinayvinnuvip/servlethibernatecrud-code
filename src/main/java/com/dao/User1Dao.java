package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.dto.User1;

public class User1Dao {
	public EntityManager getem() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vinay");
		EntityManager em = emf.createEntityManager();
		return em;
	}

	public User1 saveUser(User1 u) {
		EntityManager em = getem();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(u);
		et.commit();
		return u;
	}

	public User1 getUserById(int id) {
		EntityManager em = getem();
		User1 u = em.find(User1.class, id);
		return u;

	}

	public void removeUser(int id) {
		EntityManager em = getem();
		EntityTransaction et=em.getTransaction();
		User1 u=em.find(User1.class, id);
		et.begin();
		em.remove(u);
		et.commit();
	}

	public List<User1> getAllDetails() {
		EntityManager em = getem();
		Query q = em.createQuery("select u from User1 u");
		List<User1> list = q.getResultList();
		return list;
	}

	public User1 update(User1 u) {
		EntityManager em = getem();
		EntityTransaction et = em.getTransaction();
		et.begin();
		if (u != null) {
			em.merge(u);
			
		}
		et.commit();
		return u;

	}
}
