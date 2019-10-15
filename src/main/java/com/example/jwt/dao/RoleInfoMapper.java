package com.example.jwt.dao;



import com.example.jwt.entity.Role;

import java.util.List;

public interface RoleInfoMapper {
	/**
	 * 查询所有
	 * */
	List<Role> selectAll();
	
	/**
	 * 查询用户所有的权限
	 * */
	List<String> findModelPathByUserId(Integer userId);

	/**
	 * 增加用户角色
	 * 使用了触发器 增加id
	 * */
	void insertRole(Role param);
	
	/**
	 * 更具id删除用户
	 * */
	void deleteobj(Integer id);
	
	/**
	 * 更新角色 根据id
	 * */
	void updateRole(Role param);
	
	/**
	 * 查找用户 根据id
	 * */
	Role fetchRoleInfoById(Integer id);
}
