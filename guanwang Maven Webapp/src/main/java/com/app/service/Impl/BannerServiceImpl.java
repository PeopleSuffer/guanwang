package com.app.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.app.dao.BannerDao;
import com.app.entiey.Banner;
import com.app.service.BannerService;
@Service("bannerService")
public class BannerServiceImpl implements BannerService {

	@Resource
	private BannerDao bannerDao;
	public List<Banner> getBannerList() {
		// TODO Auto-generated method stub
		return bannerDao.getBannerList();
	}

	public Banner getBannerById(int id) {
		// TODO Auto-generated method stub
		return bannerDao.getBannerById(id);
	}

	public void addBanner(Banner banner) {
		// TODO Auto-generated method stub
		bannerDao.addBanner(banner);
	}

	public void deleteBannerById(int id) {
		// TODO Auto-generated method stub
		bannerDao.deleteBannerById(id);
	}

	public void updateBanner(Banner banner) {
		// TODO Auto-generated method stub
		bannerDao.updateBanner(banner);
	}

	public int getBannerNumber() {
		// TODO Auto-generated method stub
		return bannerDao.getBannerNumber();
	}

	public void updateBannerState(Banner banner) {
		// TODO Auto-generated method stub
		bannerDao.updateBannerState(banner);
	}

}
