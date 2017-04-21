package com.work.service;

import java.util.List;

import com.work.model.Users;
import com.work.utils.InfoError;
import com.work.utils.PageBean;

public interface UsersService {

	 public int deleteByPrimaryKey(Long id);

	 public int insert(Users record);

	 public  int insertSelective(Users record);

	 public  Users selectByPrimaryKey(Long id);

	 public  int updateByPrimaryKeySelective(Users record);

	 public int updateByPrimaryKey(Users record);
	    
	 public List<Users> findUserAll();
	    
	 public  Users findUsers(String name,String password,InfoError error);
	 
	 public PageBean<Users> findUsersAllByUsers(Users users);
	 
	 public PageBean<Users> findUsers(int index,List<Users> list,InfoError error);
}
