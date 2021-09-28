package com.example.SystemManger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SystemManger.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
