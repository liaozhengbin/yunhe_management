package cn.yunhe.biz;

import java.util.List;

import cn.yunhe.entity.PermissionInfo;

public interface PermissionBiz {
	
	//��ѯȨ��
	List<PermissionInfo> selectPermission();
	
	//ɾ��Ȩ��
	void deletePermission(int roleId);
	
	
	//���Ȩ��
	void addPermission(String permission_des);
	
	//ɾ��Ȩ��
	void deletePermission2(int roleId);
	
	//��ѯȨ��
	PermissionInfo selectPermission_index(int permission_id);
	
	//�޸�Ȩ��
	void updatePermission(int roleId,String permission_des);
	
	//��ѯȨ��
	List<PermissionInfo> selectPermission2(int roleId);
	
}
