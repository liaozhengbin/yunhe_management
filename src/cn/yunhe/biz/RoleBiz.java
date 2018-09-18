package cn.yunhe.biz;

import java.util.List;

import cn.yunhe.entity.RoleInfo;

public interface RoleBiz {
	
	
	//��ѯ��ɫ
	List<RoleInfo> selectRole();
	
	//��ӽ�ɫ����Ȩ��
	void addRole(String roleName,List<Integer> pidList);
	
	//��ӽ�ɫ����Ȩ��
	void addRole_index(int roleId,List<Integer> pidList);
	
	//�޸Ľ�ɫ����
	void updateRoleName(int roleId,String roleName);
	
	//ɾ����ɫ
	void deleteRole(int roleId);
	
	
	//�鿴��ɫȨ��
	List<RoleInfo> selectRolePms(int roleId);
	
}
