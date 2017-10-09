package com.hz.service;

import com.hz.bean.User;

public interface IUserService {
	
	/**
	 * 根据id获取用户
	 * @param id
	 * @return
	 */
	public User getUserById(int id);

}
