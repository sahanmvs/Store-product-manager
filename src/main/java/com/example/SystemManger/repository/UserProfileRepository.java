package com.example.SystemManger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SystemManger.entity.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long>{

}
