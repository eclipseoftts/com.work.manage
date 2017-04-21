package com.work.controlls;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.work.model.Users;
import com.work.service.UsersService;
import com.work.utils.InfoError;
import com.work.utils.PageBean;

@Controller
public class UsersControllers {
	
	@Autowired
	private UsersService usersService;
	
	@RequestMapping("/findUsersAll")
	public ModelAndView findUsersAll(HttpServletRequest request){
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("users");
		PageBean<Users> pageBean = usersService.findUsersAllByUsers(users);
		ModelAndView model = new ModelAndView();
		if(pageBean==null){
			model.setViewName("view/error");
		}else{
			model.addObject("pageBean", pageBean);
			HttpSession session2 = request.getSession();
			session2.setAttribute("list", pageBean.getLists());
			model.setViewName("view/centent/getUsersAll");
		}
		return model;
	}
	@RequestMapping("/findUsersPage")
	public ModelAndView findUsersPage(HttpServletRequest request,int index){
		HttpSession session = request.getSession();
		List<Users> users = (List<Users>) session.getAttribute("list");
		ModelAndView model = new ModelAndView();
		InfoError error = new InfoError();
		PageBean<Users> pageBean = usersService.findUsers(index, users, error);
		model.setViewName("view/centent/getUsersAll");
		model.addObject("list", pageBean);
		return model;
	}
	
	/***
	 * weservice 查询天气预报
	 */
	
	@RequestMapping("/wather")
	public ModelAndView getWather(){
		
		return null;
	}
}
