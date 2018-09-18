package cn.yunhe.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.yunhe.dao.PermissionDao;
import cn.yunhe.entity.PermissionInfo;
import cn.yunhe.util.ORMUtil;

public class PermissionDaoImpl implements PermissionDao {

	@Override
	public List<PermissionInfo> selectPermission() {
		// TODO Auto-generated method stub
		String sql="select * from tb_permission";
		List<PermissionInfo> permissionList=ORMUtil.ormutil().selectList(sql, null, PermissionInfo.class);
		return permissionList;
	}

	@Override
	public void deletePermission(int roleId) {
		// TODO Auto-generated method stub
		String sql="DELETE FROM tb_role_permission WHERE role_id=?";
		Object[] roleIdArray={roleId};
		ORMUtil.ormutil().performDML(sql, roleIdArray);
		
	}

	@Override
	public void addPermission(String permission_des) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO tb_permission (permission_des) VALUES (?)";
		Object[] permissionArray={permission_des};
		ORMUtil.ormutil().performDML(sql, permissionArray);

	}

	@Override
	public void deletePermission2(int roleId) {
		// TODO Auto-generated method stub
		String sql="DELETE FROM tb_permission WHERE permission_id=?";
		Object[] roleIdArray={roleId};
		ORMUtil.ormutil().performDML(sql, roleIdArray);
	}

	@Override
	public PermissionInfo selectPermission_index(int permission_id) {
		// TODO Auto-generated method stub
		String sql="select * from tb_permission where permission_id=?";
		Object[] permissionArray={permission_id};
		List<PermissionInfo> permissionList=ORMUtil.ormutil().selectList(sql, permissionArray, PermissionInfo.class);
		return permissionList.size()>0?permissionList.get(0):null;
	}

	@Override
	public void updatePermission(int roleId, String permission_des) {
		// TODO Auto-generated method stub
		String sql="UPDATE tb_permission SET permission_des=? WHERE permission_id=? ";
		Object[] pmsArray={permission_des,roleId};
		ORMUtil.ormutil().performDML(sql, pmsArray);
		
	}

	@Override
	public List<PermissionInfo> selectPermission2(int roleId) {
		// TODO Auto-generated method stub
		String sql="SELECT permission_id FROM tb_role_permission WHERE role_id=?";
		Object[] roleArray={roleId};
		List<PermissionInfo> permissionList=ORMUtil.ormutil().selectList(sql, roleArray, PermissionInfo.class);

		return permissionList;
	}

}
