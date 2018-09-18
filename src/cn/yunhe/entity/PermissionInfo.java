package cn.yunhe.entity;

public class PermissionInfo {
	private int permission_id;
	private String permission_des;
	private int role_id;
	
	
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public int getPermission_id() {
		return permission_id;
	}
	public void setPermission_id(int permission_id) {
		this.permission_id = permission_id;
	}
	public String getPermission_des() {
		return permission_des;
	}
	public void setPermission_des(String permission_des) {
		this.permission_des = permission_des;
	}
	
	public PermissionInfo(){}
	public PermissionInfo(int permission_id, String permission_des, int role_id) {
		super();
		this.permission_id = permission_id;
		this.permission_des = permission_des;
		this.role_id = role_id;
	}
	
	
	
	
	
}
