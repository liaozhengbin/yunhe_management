package cn.yunhe.entity;

public class RoleInfo {
	private int role_id;
	private String role_name;
	private int permission_id;
	public RoleInfo(){}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public int getPermission_id() {
		return permission_id;
	}
	public void setPermission_id(int permission_id) {
		this.permission_id = permission_id;
	}
	public RoleInfo(int role_id, String role_name, int permission_id) {
		super();
		this.role_id = role_id;
		this.role_name = role_name;
		this.permission_id = permission_id;
	}
	

}
