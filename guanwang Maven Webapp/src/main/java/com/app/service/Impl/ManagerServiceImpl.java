package com.app.service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.app.dao.ManagerDao;
import com.app.entiey.Manager;
import com.app.service.ManagerService;
@Service("managerService")
public class ManagerServiceImpl implements ManagerService{
	@Resource
	private ManagerDao managerDao;
	public Manager getManagerByName(Manager manager) {
		// TODO Auto-generated method stub
		return managerDao.getManagerByName(manager);
	}

	public Manager getManagerById(Integer id) {
		// TODO Auto-generated method stub
		return managerDao.getManagerById(id);
	}

	public void updateManager(Manager manager) {
		// TODO Auto-generated method stub
		managerDao.updateManager(manager);
	}

}
