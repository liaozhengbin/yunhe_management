package cn.yunhe.dao;

import java.util.List;

import cn.yunhe.entity.RoleInfo;

public interface RoleDao {
	
	//��ѯ��ɫ
	List<RoleInfo> selectRole();
	
	//��ӽ�ɫ
	int addRole(String roleName);
	
	//����ɫ����Ȩ��
	void distributionPermissions(int roleId,List<Integer> pmsIdList);
	
	//ɾ����ɫ
	void deleteRole(int roleId);
	
	//�޸Ľ�ɫ����
	void updateRoleName(int roleId,String roleName);
	//�޸Ľ�ɫȨ��
	void updateRole(int roleId,List<Integer> pmsIdList);
	
	//�鿴��ɫȨ��
	List<RoleInfo> selectRolePms(int roleId);
	
	
}
