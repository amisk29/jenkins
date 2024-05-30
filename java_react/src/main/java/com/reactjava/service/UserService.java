package com.reactjava.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reactjava.entity.Users;

public interface UserService  extends JpaRepository<Users,Long>{

}
