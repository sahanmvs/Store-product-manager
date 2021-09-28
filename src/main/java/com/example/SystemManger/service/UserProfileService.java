package com.example.SystemManger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SystemManger.entity.UserProfile;
import com.example.SystemManger.repository.UserProfileRepository;

@Service
public class UserProfileService {
	
	@Autowired
	private UserProfileRepository userProfileRepository;
	
	 public List<UserProfile> getAllUserProfiles() {
	        return userProfileRepository.findAll();
	    }
}
