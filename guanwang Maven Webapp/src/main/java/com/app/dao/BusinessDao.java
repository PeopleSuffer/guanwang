package com.app.dao;

import java.util.List;

import com.app.entiey.Business;

public interface BusinessDao {
	//查询所有业务
	List<Business> getBusinessList();
	//根据id查询单个的业务
	Business getBusinessById(Integer id);
	//查出业务的条数
	//Integer getBusinessNumber();
	//添加业务
	void addBusiness(Business business);
	//修改业务
	void updateBusinessById(Business business);
	//根据id删除单条业务
	void deleteBusinessById(Integer id);
}
