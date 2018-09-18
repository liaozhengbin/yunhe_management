package cn.yunhe.dao;

import java.util.List;

import cn.yunhe.entity.PermissionInfo;

public interface PermissionDao {
	
	//查询权限
	List<PermissionInfo> selectPermission();
	
	//删除权限
	void deletePermission(int roleId);
	
	//添加权限
	void addPermission(String permission_des);
	
	//删除权限2
	void deletePermission2(int roleId);
	
	
	//修改权限
	void updatePermission(int roleId,String permission_des);
	
	
	//查询权限
	PermissionInfo selectPermission_index(int permission_id);
	
	//查询权限
	List<PermissionInfo> selectPermission2(int roleId);
	
}
