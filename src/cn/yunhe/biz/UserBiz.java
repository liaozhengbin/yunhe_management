package cn.yunhe.biz;

import java.util.List;

import cn.yunhe.entity.UserInfo;

public interface UserBiz {
	
	/*
	 * 根据用户的用户名和密码验证是否存在
	 * 
	 * */
	UserInfo seleteUserAndPwd(String user,String pwd);
	
	//根据userId查询用户的信息
	UserInfo seleteUser(int userId);
	
	
	//查询用户信息
	List<UserInfo> seleteUserList();
	
	//添加用户
	void addUser(String user_name,String user_pwd,String user_nickname,int user_role,int class_id);
	
	//删除用户
	void deleteUser(int userId);
	
	
	//查询用户信息
	UserInfo seleteUserList_index(int userId);
	
	//修改用户
	void updateUser(String user_name,String user_pwd,String user_nickname,int user_role,int class_id,int user_id);
	
	
}
