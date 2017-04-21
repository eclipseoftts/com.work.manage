package com.work.dao;

import java.util.List;

import com.work.model.Users;


public interface UsersMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
    
    List<Users> findUserAll(int pageNo,int pageSize);
    
    Users findUsers(String name);
}