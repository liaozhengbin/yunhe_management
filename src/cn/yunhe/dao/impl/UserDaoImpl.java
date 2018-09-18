package cn.yunhe.dao.impl;

import java.util.List;

import cn.yunhe.dao.UserDao;
import cn.yunhe.entity.UserInfo;
import cn.yunhe.util.ORMUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public UserInfo seleteUserAndPwd(String user, String pwd) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM tb_user WHERE user_name=? AND user_pwd=?";
		Object[] userArray={user,pwd};
		List<UserInfo> userList=ORMUtil.ormutil().selectList(sql, userArray, UserInfo.class);
		return userList.size()>0?userList.get(0):null;
	}

	@Override
	public UserInfo seleteUser(int userId) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM tb_user where user_id=?";
		Object[] userArray={userId};
		List<UserInfo> userList=ORMUtil.ormutil().selectList(sql, userArray, UserInfo.class);
		return userList.size()>0?userList.get(0):null;
	}

	@Override
	public List<UserInfo> seleteUserList() {
		// TODO Auto-generated method stub
		String sql="SELECT t1.*,t2.class_name FROM (select t1.*,t2.role_name from tb_user t1, tb_role t2 WHERE t1.user_role=t2.role_id)t1 LEFT JOIN tb_class t2 ON t1.class_id=t2.class_id";
		List<UserInfo> userList=ORMUtil.ormutil().selectList(sql, null, UserInfo.class);
		return userList;
	}

	@Override
	public void addUser(UserInfo userInfo) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO tb_user (user_name,user_pwd,user_nickname,user_role,class_id) VALUES(?,?,?,?,?)";
		Object[] userInfoArray={userInfo.getUser_name(),userInfo.getUser_pwd(),userInfo.getUser_nickname(),userInfo.getUser_role(),userInfo.getClass_id()};
		ORMUtil.ormutil().performDML(sql, userInfoArray);
	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		String sql="DELETE FROM tb_user WHERE user_id=? ";
		Object[] userInfoArray={userId};
		ORMUtil.ormutil().performDML(sql, userInfoArray);
	}

	@Override
	public UserInfo seleteUserList_index(int userId) {
		// TODO Auto-generated method stub
		String sql="select * from tb_user WHERE user_id=? ";
		Object[] userInfoArray={userId};
		List<UserInfo> userList=ORMUtil.ormutil().selectList(sql, userInfoArray, UserInfo.class);
		return userList.size()>0?userList.get(0):null;
	}

	@Override
	public void updateUser(UserInfo userInfo) {
		String sql="UPDATE tb_user SET user_name=?,user_pwd=?,user_nickname=?,user_role=?,class_id=? WHERE user_id=?";
		Object[] userArray={userInfo.getUser_name(),userInfo.getUser_pwd(),userInfo.getUser_nickname(),userInfo.getUser_role(),userInfo.getClass_id(),userInfo.getUser_id()};
		ORMUtil.ormutil().performDML(sql, userArray);
	}

}
