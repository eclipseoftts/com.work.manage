package com.work.controlls;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.work.model.Users;
import com.work.service.UsersService;
import com.work.utils.InfoError;

/***
 * 添加备注
 * @author Administrator
 *
 */
@Controller
public class LoginControlls {

	@Autowired
	private UsersService userService;

	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView index(String name,String password,HttpServletRequest request){
		InfoError error = new InfoError();
		Users users = userService.findUsers(name, password, error);
		ModelAndView model = new ModelAndView();
		switch(error.getCode()){
			case -2:
				model.setViewName("index");
				model.addObject("error", error.getError());
				break;
			case -1:
				model.setViewName("index");
				model.addObject("error", error.getError());
				break;
			case 1:
				model.setViewName("view/home");
				model.addObject("users", users);
				HttpSession session = request.getSession();
				session.setAttribute("users", users);
				break;
			
		}
		return model;
	}
}
