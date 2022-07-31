package com.revature.models;

public class User {

	private int user_id;
	private String username;
	private String password;
	private String first_name;
	private String last_name;
	private String user_email;
	private Role role;
	private int role_id_fk;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int user_id, String username, String password) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
	}

	public User(int user_id, String username, String password, String first_name, String last_name, String user_email,
			Role role) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.user_email = user_email;
		this.role = role;
	}

	public User(int user_id, String username, String password, String first_name, String last_name, String user_email,
			int role_id_fk) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.user_email = user_email;
		this.role_id_fk = role_id_fk;
	}

	public User(String username, String password, String first_name, String last_name, String user_email, Role role) {
		super();
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.user_email = user_email;
		this.role = role;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public int getUser_role_id_fk() {
		return role_id_fk;
	}

	public void setUser_role_id_fk(int role_id_fk) {
		this.role_id_fk = role_id_fk;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", password=" + password + ", first_name="
				+ first_name + ", last_name=" + last_name + ", user_email=" + user_email + ", role=" + role
				+ ", user_role_id_fk=" + role_id_fk + "]";
	}
	
	

	
}
