package cn.yunhe.biz.impl;

import java.util.List;

import cn.yunhe.biz.UserBiz;
import cn.yunhe.dao.UserDao;
import cn.yunhe.dao.impl.UserDaoImpl;
import cn.yunhe.entity.UserInfo;

public class UserBizImpl implements UserBiz {
	private UserDao userDao=new UserDaoImpl();
	@Override
	public UserInfo seleteUserAndPwd(String user, String pwd) {
		// TODO Auto-generated method stub
		return userDao.seleteUserAndPwd(user, pwd);
		
	}
	@Override
	public UserInfo seleteUser(int userId) {
		// TODO Auto-generated method stub
		return userDao.seleteUser(userId);
	}
	@Override
	public List<UserInfo> seleteUserList() {
		// TODO Auto-generated method stub
		return userDao.seleteUserList();
	}
	@Override
	public void addUser(String user_name, String user_pwd,
			String user_nickname, int user_role, int class_id) {
		// TODO Auto-generated method stub
		UserInfo userInfo=new UserInfo();
		userInfo.setUser_name(user_name);
		userInfo.setUser_pwd(user_pwd);
		userInfo.setUser_nickname(user_nickname);
		userInfo.setUser_role(user_role);
		userInfo.setClass_id(class_id);
		
		userDao.addUser(userInfo);
		
	}
	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		userDao.deleteUser(userId);
	}
	@Override
	public UserInfo seleteUserList_index(int userId) {
		// TODO Auto-generated method stub
		return userDao.seleteUserList_index(userId);
	}
	@Override
	public void updateUser(String user_name, String user_pwd,
			String user_nickname, int user_role, int class_id, int user_id) {
		// TODO Auto-generated method stub
		UserInfo userInfo=new UserInfo();
		userInfo.setUser_name(user_name);
		userInfo.setUser_pwd(user_pwd);
		userInfo.setUser_nickname(user_nickname);
		userInfo.setUser_role(user_role);
		userInfo.setClass_id(class_id);
		userInfo.setUser_id(user_id);
		userDao.updateUser(userInfo);
		
	}

}
