package com.service;

import java.util.List;

import com.dao.User1Dao;
import com.dto.User1;

public class User1Service {
	User1Dao dao=new User1Dao();
	public User1 getUserById(int id) {
		return dao.getUserById(id);
	}
	public User1 saveUser(User1 u) {
		return dao.saveUser(u);
	}
	public void removeUser(int id) {
		 dao.removeUser(id);
	}
	public List<User1> getAllDetails(){
		return dao.getAllDetails();
	}
	public User1 update(User1 u) {
		return dao.update(u);
	}
}