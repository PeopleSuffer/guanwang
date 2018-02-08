package com.app.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.app.dao.BusinessDao;
import com.app.entiey.Business;
import com.app.service.BusinessService;
@Service("businessService")
public class BusinessServiceImpl implements BusinessService {
	@Resource
	private BusinessDao businessDao;
	public List<Business> getBusinessList() {
		// TODO Auto-generated method stub
		return businessDao.getBusinessList();
	}

	public Business getBusinessById(Integer id) {
		// TODO Auto-generated method stub
		return businessDao.getBusinessById(id);
	}

	public void addBusiness(Business business) {
		// TODO Auto-generated method stub
		businessDao.addBusiness(business);
	}

	public void updateBusinessById(Business business) {
		// TODO Auto-generated method stub
		businessDao.updateBusinessById(business);
	}

	public void deleteBusinessById(Integer id) {
		// TODO Auto-generated method stub
		businessDao.deleteBusinessById(id);
	}
	
}
