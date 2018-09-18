package cn.yunhe.biz.impl;

import java.util.List;

import cn.yunhe.biz.RoleBiz;
import cn.yunhe.dao.RoleDao;
import cn.yunhe.dao.impl.RoleDaoImpl;
import cn.yunhe.entity.RoleInfo;

public class RoleBizImpl implements RoleBiz {
	private RoleDao roleDao=new RoleDaoImpl();
	@Override
	public List<RoleInfo> selectRole() {
		// TODO Auto-generated method stub
		return roleDao.selectRole();
	}
	@Override
	public void addRole(String roleName, List<Integer> pidList) {
		// TODO Auto-generated method stub
		int pid=roleDao.addRole(roleName);
		roleDao.distributionPermissions(pid, pidList);
		
	}
	@Override
	public void deleteRole(int roleId) {
		// TODO Auto-generated method stub
		roleDao.deleteRole(roleId);
	}
	@Override
	public List<RoleInfo> selectRolePms(int roleId) {
		// TODO Auto-generated method stub
		return roleDao.selectRolePms(roleId);
	}
	@Override
	public void addRole_index(int roleId, List<Integer> pidList) {
		// TODO Auto-generated method stub
		roleDao.distributionPermissions(roleId, pidList);
	}
	@Override
	public void updateRoleName(int roleId, String roleName) {
		// TODO Auto-generated method stub
		roleDao.updateRoleName(roleId, roleName);
	}
	
	
	

}
