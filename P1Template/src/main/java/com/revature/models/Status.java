package com.revature.models;

public class Status {

	private int status_id;
	private String reimb_status;
	
	public Status(int status_id, String reimb_status) {
		super();
		this.status_id = status_id;
		this.reimb_status = reimb_status;
	}

	public int getStatus_id() {
		return status_id;
	}

	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}

	public String getReimb_status() {
		return reimb_status;
	}

	public void setReimb_status(String reimb_status) {
		this.reimb_status = reimb_status;
	}

	@Override
	public String toString() {
		return "Status [status_id=" + status_id + ", reimb_status=" + reimb_status + "]";
	}
	
	
	
	
	
}
