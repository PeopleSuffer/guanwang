package com.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.common.BaseResult;
import com.app.entiey.Business;
import com.app.service.BusinessService;
@Controller
@RequestMapping("business")
public class BusinessController {
	@Resource(name="businessService")
	private BusinessService businessService;
	/**
	 * 查询所有业务
	 * @return
	 */
	@RequestMapping("all")
	@ResponseBody
	public List<Business> getBusinessList() {
		return businessService.getBusinessList();
	}
	/**
	 * 查询所有业务,前端展示不拦截
	 * @return
	 */
	@RequestMapping("all.do")
	@ResponseBody
	public List<Business> getBusinessListAPP() {
		return businessService.getBusinessList();
	}
	/**
	 * 根据id查询业务
	 * @param id
	 * @return
	 */
	@RequestMapping("findById.do")
	@ResponseBody
	public Business getBusinessById(Integer id) {
		return businessService.getBusinessById(id);
	}
	/**
	 * 添加业务
	 * @param businessTitle
	 * @param businessContent
	 * @return
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ResponseBody
	public BaseResult addBusiness(String businessTitle,String businessContent) {
		//1.实例化对象
		Business business = new Business();
		//2.获取当前时间
		SimpleDateFormat formatter = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		String date = formatter.format(new Date());
		//3.传入数据
		business.setBusinessTitle(businessTitle);
		business.setBusinessContent(businessContent);
		business.setCreateTime(date);
		//4.添加到数据库
		businessService.addBusiness(business);
		return BaseResult.ok();
	}
	/**
	 * 根据id修改业务
	 * @param id
	 * @param businessTitle
	 * @param businessContent
	 * @return
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	@ResponseBody
	public BaseResult updateBusinessById(Integer id,String businessTitle,String businessContent) {
		if(null==id||null==businessService.getBusinessById(id)){
			return BaseResult.build(500, "修改错误");
		}
		//1.实例化对象
		Business business = new Business();
		//2.传入数据
		business.setBusinessTitle(businessTitle);
		business.setBusinessContent(businessContent);
		business.setId(id);
		//3.更新到数据库
		businessService.updateBusinessById(business);
		return BaseResult.ok();
	}
	/**
	 * 根据id单个删除
	 * @param id
	 */
	@RequestMapping("deleteById")
	@ResponseBody
	public BaseResult deleteBusinessById(Integer id) {
		if(null==id||null==businessService.getBusinessById(id)){
			return BaseResult.build(500, "修改错误");
		}
		businessService.deleteBusinessById(id);
		return BaseResult.ok();
	}
	/**
	 * 删除多个
	 * @param ids
	 * @return
	 */
	@RequestMapping("deletes")
	@ResponseBody
	public BaseResult deleteBusinesss(String ids) {
		if (null == ids || ids.equals("")) {
			return BaseResult.build(500, "id传入错误");
		}else if (!ids.contains(",")) {
			int id = Integer.parseInt(ids);
			if (id > 0 && null != businessService.getBusinessById(id)) {
				businessService.deleteBusinessById(id);
				return BaseResult.ok();
				
			} else {
				return BaseResult.build(500, "id错误");
			}
		}else {
			String[] postcode = ids.split(",");
			for (int i = 0; i < postcode.length; i++) {
				int id = Integer.parseInt(postcode[i]);
				if (id < 1 || null == businessService.getBusinessById(id)) {
					return BaseResult.build(500, "传入的id有误");
				}
			}
			for (int i = 0; i < postcode.length; i++) {
				int id = Integer.parseInt(postcode[i]);
				businessService.deleteBusinessById(id);
			}
			return BaseResult.ok();
		}
	}
}
