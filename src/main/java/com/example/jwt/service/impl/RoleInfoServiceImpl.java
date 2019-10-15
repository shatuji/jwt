package com.example.jwt.service.impl;

import com.example.jwt.dao.RoleInfoMapper;
import com.example.jwt.entity.Role;
import com.example.jwt.service.RoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.relation.RoleInfo;
import java.util.List;

@Service
@Transactional
public class RoleInfoServiceImpl implements RoleInfoService {

	@Autowired
	private RoleInfoMapper roleInfoMapper;
	@Override
	public List<String> findModelPathByUserId(Integer userId) {
		return this.roleInfoMapper.findModelPathByUserId(userId);
	}
	
	
	@Override
	public List<Role> selectAll() {
	return this.roleInfoMapper.selectAll();
	}


	@Override
	public void insertRoleInfo(Role param) {
		this.roleInfoMapper.insertRole(param);
	}

	@Override
	public void deleteRoleInfoById(Integer id) {
		this.roleInfoMapper.deleteobj(id);
		//删除角色之后还要删除对应的角色权限
		//this.powersetMapper.deleteRoleRefPri(id);
	}


	@Override
	@Transactional
	public void updateRoleInfo(Role param) {
		this.roleInfoMapper.updateRole(param);
	}


	@Override
	@Transactional
	public Role fetchRoleInfoById(Integer id) {
		return this.roleInfoMapper.fetchRoleInfoById(id);
	}
	
}
