package com.reactjava.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.reactjava.entity.Users;
import com.reactjava.exception.UserNotFound;
import com.reactjava.service.UserService;
@Service
public class UserServiceImp implements UserServiceInter {
	@Autowired
	private UserService service;
	@Override
	public Users addUsers(Users user) {
		Users save = this.service.save(user);
		return save;
	}
	@Override
	public List<Users> viewAllUses() {
		List<Users> findAll =this.service.findAll();
		return findAll;
	}
	
	@Override
	public Users getUserById( Long id) {
		Users user = service.findById(id).orElseThrow(()->new UserNotFound(" user not found with id "+ id ));
		return  user;
		
	}
	@Override
	public Users updateUser(Long id, Users user) {
		Users user1 = service.findById(id).orElseThrow(()->new UserNotFound(" user not found with id "+ id ));
		user1.setName(user.getName());
		user1.setEmail(user.getEmail());
		user1.setAddress(user.getAddress());
		user1.setPassword(user.getPassword());
		this.service.save(user1);
		return user1;
	}
	@Override
	public void delete(Long id) {
		Users user = service.findById(id).orElseThrow(()->new UserNotFound(" user not found with id "+ id ));
		if(user!=null)
		{
			this.service.deleteById(id);
			
		}
		
	}
	
}


