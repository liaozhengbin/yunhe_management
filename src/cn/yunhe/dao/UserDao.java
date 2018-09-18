package cn.yunhe.dao;



import java.util.List;

import cn.yunhe.entity.UserInfo;

public interface UserDao {
	
	
	/*
	 * �����û����û�����������֤�Ƿ����
	 * 
	 * */
	UserInfo seleteUserAndPwd(String user,String pwd);
	
	
	
	//����userId��ѯ�û�����Ϣ
	UserInfo seleteUser(int userId);
	
	//��ѯ�û���Ϣ
	List<UserInfo> seleteUserList();
	
	
	//����û�
	void addUser(UserInfo userInfo);
	
	
	//ɾ���û�
	void deleteUser(int userId);
	
	
	//��ѯ�û���Ϣ
	UserInfo seleteUserList_index(int userId);
	
	
	//�޸��û�
	void updateUser(UserInfo userInfo);
	
	
}
