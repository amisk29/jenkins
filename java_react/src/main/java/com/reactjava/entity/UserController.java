package com.reactjava.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.reactjava.serviceImp.UserServiceInter;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {
	@Autowired
	private UserServiceInter inter;

	@PostMapping("/users/add")
	public Users addUserData(@RequestBody Users users) {
		Users user = this.inter.addUsers(users);
		return user;

	}

	@GetMapping("/users/getall")
	public List<Users> getAllUsers() {
		List<Users> viewAllUses = this.inter.viewAllUses();
		return viewAllUses;

	}

	@GetMapping("/users/user/{id}")
	public ResponseEntity<Users> getUserByUserId(@PathVariable Long id) {
		Users userById = this.inter.getUserById(id);
		return new ResponseEntity<Users>(userById, HttpStatus.OK);

	}

	@PutMapping("/users/update/{id}")
	public ResponseEntity<Users> updateUser(@PathVariable Long id, @RequestBody Users users) {
		Users updateUser = this.inter.updateUser(id, users);
		return new ResponseEntity<Users>(updateUser, HttpStatus.OK);

	}

	@DeleteMapping("/users/delete/{id}")
	public ResponseEntity<Long> deleteUser(@PathVariable Long id) {
		this.inter.delete(id);
		return new ResponseEntity<Long>(id, HttpStatus.OK);

	}

	@GetMapping("/hi")
	public String test() {
		return "test";
	}

}
