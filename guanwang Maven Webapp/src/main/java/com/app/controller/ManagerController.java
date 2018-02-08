package com.app.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.common.BaseResult;
import com.app.entiey.Manager;
import com.app.service.ManagerService;

@Controller
@RequestMapping("manager")
public class ManagerController {
	@Resource(name="managerService")
	private ManagerService managerService;
	/**
	 * 根据用户名和密码获取用户
	 * @param managerName
	 * @param possWord
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getManagerByName(String managerName,String passWord,HttpServletRequest request) {
		//实例化对象
		Manager managerboss=new Manager();
		managerboss.setName(managerName);
		managerboss.setPassword(passWord);
		//返回的数据
		Map<String, Object> map=new HashMap<String, Object>();
		//获取的数据
		Manager manager=managerService.getManagerByName(managerboss);
		//判断获取的值是否为空
		if (null==managerService.getManagerByName(managerboss)) {
			map.put("code", 500);
			map.put("message", "账号或密码错误");
			return map;
		}
		//将manager加入到session中
		map.put("code", 200);
		map.put("message", manager);
		HttpSession session = request.getSession();
        session.setAttribute("manager", manager);
		return map;
	}
	/**
	 * 根据id获取用户
	 * @param id
	 * @return
	 */
	@RequestMapping("findById")
	@ResponseBody
	public Manager getManagerById(Integer id) {
		if (null!=id&&id>0) {
			return managerService.getManagerById(id);
		}
		return null;
	}

	/**
	 * 修改账号和密码
	 * @param id
	 * @param managerName
	 * @param possWord
	 * @return
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	@ResponseBody
	public BaseResult updateManager(Integer id,String managerName,String passWord) {
		//判断id是否输入正确
		if (null==id||null==managerService.getManagerById(id)) {
			return BaseResult.build(500, "输入参数错误");
		}
		//判断输入的值是否合法
		if (null!=managerName&&!managerName.equals("")&&null!=passWord&&!passWord.equals("")) {
			//实例化对象
			Manager manager=new Manager();
			//上传id
			manager.setId(id);
			//上传managerName
			manager.setName(managerName);
			//上传possWord
			manager.setPassword(passWord);
			//更新操作
			managerService.updateManager(manager);
			return BaseResult.ok();
		}
		return BaseResult.build(500, "操作错误");
	}
	/**
	 * 用户退出
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("exitManager")
	@ResponseBody
	public String exitManager(HttpServletRequest request,
			HttpServletResponse response) {
		request.getSession().invalidate();
		try {
			System.out.println(1);
			request.getSession().removeAttribute("manager");
			//request.session.removeAttribute("uiUsers")；
			//response.sendRedirect("http://www.yehaikeji.com:8080/taoxingzhi/login.html");
			//System.out.println(request.getContextPath()+"/login.html");
			return "1";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "0";
	}
}
