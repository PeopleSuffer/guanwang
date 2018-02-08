package com.app.dao;

import java.util.List;

import com.app.entiey.Banner;

public interface BannerDao {

	//查询所有banner
	List<Banner> getBannerList();
	//查询单个banner
	Banner getBannerById(int id);
	//添加banner
	void addBanner(Banner banner);
	//删除banner
	void deleteBannerById(int id);
	//修改
	void updateBanner(Banner banner);
	//修改状态
	void updateBannerState(Banner banner);
	//获得banner的条数
	int getBannerNumber();
	
}
