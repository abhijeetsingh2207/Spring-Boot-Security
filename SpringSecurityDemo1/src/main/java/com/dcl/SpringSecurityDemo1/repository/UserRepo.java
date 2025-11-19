package com.dcl.SpringSecurityDemo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dcl.SpringSecurityDemo1.model.Users;


@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {

	Users findByUsername(String username);

}
