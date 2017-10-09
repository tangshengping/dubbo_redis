package com.hz.service.impl;

import javax.annotation.Resource;

import com.hz.bean.User;
import com.hz.service.IUserService;

//@Service
public class MarketUserService {
 
//    @Reference(version = "1.0.0",check=false,init=false)
	@Resource(name="userService")
    private IUserService userService;
 
    public User getUserById(int id){
    	return userService.getUserById(id);
    }

}
