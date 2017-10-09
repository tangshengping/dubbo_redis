package com.hz.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hz.bean.User;
import com.hz.service.impl.MarketUserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Resource 
	private MarketUserService userService;
	
    @RequestMapping("get")
    public User getUserById() {
    	 User user = userService.getUserById(1);
		return user;
    }

}
