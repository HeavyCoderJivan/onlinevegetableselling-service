package com.onlinevegetable.repository.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinevegetable.model.User;
import com.onlinevegetable.repository.UserRepository;

@Service
public class UserService 
{
	@Autowired
	private UserRepository userRepo;
	
	public List<User> getAllUsers()
	{
		return userRepo.findAll();
	}
	
	public User getUserById(Integer id) 
	{
		return userRepo.findById(id).orElseThrow();
	}
	
	public User addUser(User user) 
	{
		return userRepo.save(user);	
	}
	
	public User getUserByEmail(String email) 
	{
		return userRepo.getUserByEmail(email);	
	}
	
	public void deleteUserByID(Integer id) 
	{
		userRepo.deleteById(id);
	}

}
