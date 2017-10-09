package com.hz.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.hz.bean.User;
import com.hz.service.IUserService;

@Service(version="1.0.0")
public class UserServiceImpl implements IUserService{

	@Override
	public User getUserById(int id) {
		User user = new User();
		user.setId(id);
		user.setName("testName");
		return user;
	}

}
