package cn.yunhe.dao;

import java.util.List;

import cn.yunhe.entity.PermissionInfo;

public interface PermissionDao {
	
	//��ѯȨ��
	List<PermissionInfo> selectPermission();
	
	//ɾ��Ȩ��
	void deletePermission(int roleId);
	
	//���Ȩ��
	void addPermission(String permission_des);
	
	//ɾ��Ȩ��2
	void deletePermission2(int roleId);
	
	
	//�޸�Ȩ��
	void updatePermission(int roleId,String permission_des);
	
	
	//��ѯȨ��
	PermissionInfo selectPermission_index(int permission_id);
	
	//��ѯȨ��
	List<PermissionInfo> selectPermission2(int roleId);
	
}
