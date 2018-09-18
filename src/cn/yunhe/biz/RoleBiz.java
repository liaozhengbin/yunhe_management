package cn.yunhe.biz;

import java.util.List;

import cn.yunhe.entity.RoleInfo;

public interface RoleBiz {
	
	
	//查询角色
	List<RoleInfo> selectRole();
	
	//添加角色分配权限
	void addRole(String roleName,List<Integer> pidList);
	
	//添加角色分配权限
	void addRole_index(int roleId,List<Integer> pidList);
	
	//修改角色名字
	void updateRoleName(int roleId,String roleName);
	
	//删除角色
	void deleteRole(int roleId);
	
	
	//查看角色权限
	List<RoleInfo> selectRolePms(int roleId);
	
}
