package com.reactjava.serviceImp;

import java.util.List;

import com.reactjava.entity.Users;

public interface UserServiceInter {
	Users addUsers(Users users);
	List<Users>viewAllUses();
	Users updateUser(Long id,Users user);
	Users getUserById(Long id);
	void delete(Long id);

}
