package com.Employee.App.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employee.App.model.Admin;
import com.Employee.App.repository.AdminRepository;

@Service
public class AdminServiceImpl  implements AdminService {
	
@Autowired
private AdminRepository repo;
 
	
	public Admin admin(String username, String password) {	  
	Admin admin = repo.findByUsernameAndPassword(username, password);
	return admin;
	}
  
}
