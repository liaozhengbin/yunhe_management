package cn.yunhe.biz;

import java.util.List;

import cn.yunhe.entity.UserInfo;

public interface UserBiz {
	
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
	void addUser(String user_name,String user_pwd,String user_nickname,int user_role,int class_id);
	
	//ɾ���û�
	void deleteUser(int userId);
	
	
	//��ѯ�û���Ϣ
	UserInfo seleteUserList_index(int userId);
	
	//�޸��û�
	void updateUser(String user_name,String user_pwd,String user_nickname,int user_role,int class_id,int user_id);
	
	
}
