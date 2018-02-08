package com.app.service;

import com.app.entiey.Manager;


public interface ManagerService {
	//根据用户名和密码获取用户
	Manager getManagerByName(Manager manager);
	//根据id获取用户
	Manager getManagerById(Integer id);
	//根据id修改用户
	void updateManager(Manager manager);
}
