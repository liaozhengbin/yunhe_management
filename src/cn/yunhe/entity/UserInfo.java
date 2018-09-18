package cn.yunhe.entity;

public class UserInfo {
	private int user_id;
	private String user_name;
	private String user_pwd;
	private int user_type;
	private String user_openid;
	private int user_role;
	private String user_nickname;
	private int class_id;
	private String role_name;
	private String class_name;
	
	
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public int getUser_type() {
		return user_type;
	}
	public void setUser_type(int user_type) {
		this.user_type = user_type;
	}
	public String getUser_openid() {
		return user_openid;
	}
	public void setUser_openid(String user_openid) {
		this.user_openid = user_openid;
	}
	public int getUser_role() {
		return user_role;
	}
	public void setUser_role(int user_role) {
		this.user_role = user_role;
	}
	public String getUser_nickname() {
		return user_nickname;
	}
	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}
	public int getClass_id() {
		return class_id;
	}
	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}
	public UserInfo(){}
	public UserInfo(int user_id, String user_name, String user_pwd,
			int user_type, String user_openid, int user_role,
			String user_nickname, int class_id, String role_name,
			String class_name) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_pwd = user_pwd;
		this.user_type = user_type;
		this.user_openid = user_openid;
		this.user_role = user_role;
		this.user_nickname = user_nickname;
		this.class_id = class_id;
		this.role_name = role_name;
		this.class_name = class_name;
	}
	
	
	
	
	
	
	
}
