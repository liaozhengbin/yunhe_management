package cn.yunhe.dao.impl;

import java.util.List;

import cn.yunhe.dao.RoleDao;
import cn.yunhe.entity.RoleInfo;
import cn.yunhe.util.ORMUtil;

public class RoleDaoImpl implements RoleDao {

	@Override
	public List<RoleInfo> selectRole() {
		// TODO Auto-generated method stub
		String sql="select * from tb_role";
		List<RoleInfo> roleList=ORMUtil.ormutil().selectList(sql, null, RoleInfo.class);
		return roleList;
	}

	@Override
	public int addRole(String roleName) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO tb_role (role_name) VALUES (?)";
		Object[] roleArray={roleName};
		return ORMUtil.ormutil().performDML_index(sql, roleArray);
		
	}

	@Override
	public void distributionPermissions(int roleId, List<Integer> pmsIdList) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO tb_role_permission (role_id,permission_id) VALUES ";
		
		for(int i=0;i<pmsIdList.size();i++){
			int pid=pmsIdList.get(i);
			sql+="("+roleId+","+pid+")";
			if(i!=pmsIdList.size()-1){
				sql+=",";
			}
			
		}
		ORMUtil.ormutil().performDML(sql, null);
		
	}

	@Override
	public void deleteRole(int roleId) {
		// TODO Auto-generated method stub
		String sql="DELETE FROM tb_role WHERE role_id=?";
		Object[] roleIdArray={roleId};
		ORMUtil.ormutil().performDML(sql, roleIdArray);
		
		
	}

	

	@Override
	public List<RoleInfo> selectRolePms(int roleId) {
		// TODO Auto-generated method stub
		String sql="select t1.*,t2.permission_id from tb_role t1,tb_role_permission t2 WHERE t1.role_id=t2.role_id AND t1.role_id=? ";
		Object[] roleIdArray={roleId};
		List<RoleInfo> roleList=ORMUtil.ormutil().selectList(sql, roleIdArray, RoleInfo.class);
		
		return roleList;
	}

	@Override
	public void updateRoleName(int roleId, String roleName) {
		// TODO Auto-generated method stub
		String sql="UPDATE tb_role SET role_name=? WHERE role_id=? ";
		Object[] roleArray={roleName,roleId};
		ORMUtil.ormutil().performDML(sql, roleArray);
		
	}

	@Override
	public void updateRole(int roleId, List<Integer> pmsIdList) {
		// TODO Auto-generated method stub
		
	}

	
}
