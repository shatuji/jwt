package com.example.jwt.service;


import com.example.jwt.entity.Role;

import java.util.List;

public interface RoleInfoService {
	//List<JdRole> selectAll();
	/**
	 * 根据登录用户查询对应的模板路径
	 * 返回前台 用在权限验证 和 模板控制
	 * */
	List<String> findModelPathByUserId(Integer userId);
	
	/**
	 * 查询所有的角色
	 * */
	List<Role> selectAll();
	
	/**
	 * 增加用户
	 * */
	void insertRoleInfo(Role param);
	
	/**
	 * 删除用户
	 * */
	void deleteRoleInfoById(Integer id);
	
	/**
	 * 更新角色信息
	 * */
	void updateRoleInfo(Role param);
	
	/**
	 * 查找用户 根据用户id
	 * */
	Role fetchRoleInfoById(Integer id);
}
