package com.example.SystemManger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.SystemManger.service.UserProfileService;

@Controller
public class UserProfileController {
	@Autowired
	private UserProfileService userProfileService;
}
