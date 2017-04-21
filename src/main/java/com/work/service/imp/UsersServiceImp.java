package com.work.service.imp;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.work.dao.UsersMapper;
import com.work.model.Users;
import com.work.service.UsersService;
import com.work.utils.InfoError;
import com.work.utils.NumberIsEmpty;
import com.work.utils.PageBean;

import sun.misc.BASE64Encoder;

@Service("userService")
public class UsersServiceImp implements UsersService {
	
	@Autowired
	private UsersMapper usersMapper;

	@Override
	public int deleteByPrimaryKey(Long id) {
		return 0;
	}

	@Override
	public int insert(Users record) {
		
		return 0;
	}

	@Override
	public int insertSelective(Users record) {
		
		return 0;
	}

	@Override
	public Users selectByPrimaryKey(Long id) {
		
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Users record) {
		
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Users record) {
		
		return 0;
	}

	@Override
	public List<Users> findUserAll() {
		
		return null;
	}

	/***
	 * 用于用户登录
	 */
	@Override
	public Users findUsers(String name,String password,InfoError error) {
		error.clear();
		if(!NumberIsEmpty.stringIsEmpty(name)){
			error.setCode(-1);
			error.setError("用户名不能为空！");
			return null;
		}
		if(!NumberIsEmpty.stringIsEmpty(password)){
			error.setCode(-1);
			error.setError("密码不能为空！");
			return null;
		}
		Users users = usersMapper.findUsers(name);
		if(users == null){
			error.setCode(-1);
			error.setError("用户名不存在！");
			return null;
		}
		
		try {
			String pass = NumberIsEmpty.EncoderByMd5(password);
			
			if(!users.getPassword().equals(pass)){
				error.setCode(-1);
				error.setError("密码错误！");
				return null;
			}
		} catch (NoSuchAlgorithmException e1) {
			System.out.println("MD5 加密时");
			e1.printStackTrace();
			error.setCode(-2);
			error.setError("MD5 加密时  ----------请联系开发人员！");
			return null;
		} catch (UnsupportedEncodingException e1) {
			System.out.println("MD5 加密后，字符转换时");
			e1.printStackTrace();
			error.setCode(-2);
			error.setError("MD5 加密后，字符转换时--- 请联系开发人员！");
			return null;
		}
		
        error.setCode(1);
		error.setError("登录成功！");
		return users;
	}
	/***
	 * 根据用权限查询
	 */
	public PageBean<Users> findUsersAllByUsers(Users users){
		PageBean<Users> pageBean = new PageBean<Users>();
		switch(users.getGrades()){
			case 0:
				pageBean = null;
				break;
			case 1:
				List<Users> list = usersMapper.findUserAll(0,10);
				pageBean.setOffPage(10);
				pageBean.setIndex(0);
				pageBean.setCountNum(list.size());
				pageBean.setLists(list);
				break;
		}
		
		return pageBean;
	}
	/***
	 * 分页查询
	 */
	public PageBean<Users> findUsers(int index,List<Users> list,InfoError error){
		error.clear();
		PageBean<Users> pageBean = new PageBean<Users>();
		pageBean.setIndex(index);
		pageBean.setCountNum(list.size());
		pageBean.setLists(list);
		return pageBean;
	}

}
