package com.revature.models;

public class Type {
	
	private int type_id;
	private String type;
	
	public Type() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Type(int type_id, String type) {
		super();
		this.type_id = type_id;
		this.type = type;
	}
	
	public int getType_id() {
		return type_id;
	}
	
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String reimb_type) {
		this.type = reimb_type;
	}
	
	@Override
	public String toString() {
		return "Type [type_id=" + type_id + ", type=" + type + "]";
	}
	

	
	
	
}
