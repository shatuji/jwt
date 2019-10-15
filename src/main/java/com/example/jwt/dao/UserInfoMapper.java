package com.example.jwt.dao;


import com.example.jwt.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserInfoMapper {

	/**
	 * find user entity information hit database from mysql
	 * @param account
	 * @return
	 */
	User findJdUserByAccount(@Param("account") String account);

	/**
	 * 根据id查询
	 * */
	User findEntityById(Integer id);

	/**
	 * 增加用户
	 * */
	void insertEntity(User param);
}
