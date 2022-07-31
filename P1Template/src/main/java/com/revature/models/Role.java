package com.revature.models;

public class Role {

	private int role_id;
	private String title;
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(int role_id, String title) {
		super();
		this.role_id = role_id;
		this.title = title;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getRole_title() {
		return title;
	}

	public void setRole_title(String role_title) {
		this.title = role_title;
	}

	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", role_title=" + title + "]";
	}

	
	
}
