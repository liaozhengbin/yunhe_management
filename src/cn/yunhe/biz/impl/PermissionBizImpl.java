package cn.yunhe.biz.impl;

import java.util.List;

import cn.yunhe.biz.PermissionBiz;
import cn.yunhe.dao.PermissionDao;
import cn.yunhe.dao.impl.PermissionDaoImpl;
import cn.yunhe.entity.PermissionInfo;

public class PermissionBizImpl implements PermissionBiz {
	private PermissionDao permissionDao=new PermissionDaoImpl();

	@Override
	public List<PermissionInfo> selectPermission() {
		// TODO Auto-generated method stub
		return permissionDao.selectPermission();
	}

	@Override
	public void deletePermission(int roleId) {
		// TODO Auto-generated method stub
		
		permissionDao.deletePermission(roleId);
	}

	@Override
	public void addPermission(String permission_des) {
		// TODO Auto-generated method stub
		permissionDao.addPermission(permission_des);
	}

	@Override
	public void deletePermission2(int roleId) {
		// TODO Auto-generated method stub
		permissionDao.deletePermission2(roleId);
	}

	@Override
	public PermissionInfo selectPermission_index(int permission_id) {
		// TODO Auto-generated method stub
		return permissionDao.selectPermission_index(permission_id);
	}

	@Override
	public void updatePermission(int roleId, String permission_des) {
		// TODO Auto-generated method stub
		permissionDao.updatePermission(roleId, permission_des);
	}

	@Override
	public List<PermissionInfo> selectPermission2(int roleId) {
		// TODO Auto-generated method stub
		return permissionDao.selectPermission2(roleId);
	}

}
