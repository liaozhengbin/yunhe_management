package cn.yunhe.dao;

import java.util.List;

import cn.yunhe.entity.RoleInfo;

public interface RoleDao {
	
	//查询角色
	List<RoleInfo> selectRole();
	
	//添加角色
	int addRole(String roleName);
	
	//给角色分配权限
	void distributionPermissions(int roleId,List<Integer> pmsIdList);
	
	//删除角色
	void deleteRole(int roleId);
	
	//修改角色名字
	void updateRoleName(int roleId,String roleName);
	//修改角色权限
	void updateRole(int roleId,List<Integer> pmsIdList);
	
	//查看角色权限
	List<RoleInfo> selectRolePms(int roleId);
	
	
}
