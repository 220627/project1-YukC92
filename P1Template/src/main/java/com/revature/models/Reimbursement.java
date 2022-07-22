package com.revature.models;

import java.io.InputStream;
import java.sql.Timestamp;

public class Reimbursement {

	private int reimb_id;
	private int reimb_amount;
	private Timestamp reimb_sumitted;
	private Timestamp reimb_resolved;
	private String reimb_description;
	private InputStream reimb_recipt;
	private User reimb_author;
	private User reimb_resolver;
	private Status reimb_status;
	private Type reimb_type;
	
	public Reimbursement(int reimb_id, int reimb_amount, Timestamp reimb_sumitted, Timestamp reimb_resolved,
			String reimb_description, InputStream reimb_recipt, User reimb_author, User reimb_resolver,
			Status reimb_status, Type reimb_type) {
		super();
		this.reimb_id = reimb_id;
		this.reimb_amount = reimb_amount;
		this.reimb_sumitted = reimb_sumitted;
		this.reimb_resolved = reimb_resolved;
		this.reimb_description = reimb_description;
		this.reimb_recipt = reimb_recipt;
		this.reimb_author = reimb_author;
		this.reimb_resolver = reimb_resolver;
		this.reimb_status = reimb_status;
		this.reimb_type = reimb_type;
	}

	public Reimbursement(int reimb_id, Timestamp reimb_resolved, User reimb_resolver, Status reimb_status) {
		super();
		this.reimb_id = reimb_id;
		this.reimb_resolved = reimb_resolved;
		this.reimb_resolver = reimb_resolver;
		this.reimb_status = reimb_status;
	}
	
	@Override
	public String toString() {
		return "Reimbursement [reimb_id=" + reimb_id + ", reimb_amount=" + reimb_amount + ", reimb_sumitted="
				+ reimb_sumitted + ", reimb_resolved=" + reimb_resolved + ", reimb_description=" + reimb_description
				+ ", reimb_recipt=" + reimb_recipt + ", reimb_author=" + reimb_author + ", reimb_resolver="
				+ reimb_resolver + ", reimb_status=" + reimb_status + ", reimb_type=" + reimb_type + "]";
	}

	public int getReimb_id() {
		return reimb_id;
	}

	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}

	public int getReimb_amount() {
		return reimb_amount;
	}

	public void setReimb_amount(int reimb_amount) {
		this.reimb_amount = reimb_amount;
	}

	public Timestamp getReimb_sumitted() {
		return reimb_sumitted;
	}

	public void setReimb_sumitted(Timestamp reimb_sumitted) {
		this.reimb_sumitted = reimb_sumitted;
	}

	public Timestamp getReimb_resolved() {
		return reimb_resolved;
	}

	public void setReimb_resolved(Timestamp reimb_resolved) {
		this.reimb_resolved = reimb_resolved;
	}

	public String getReimb_description() {
		return reimb_description;
	}

	public void setReimb_description(String reimb_description) {
		this.reimb_description = reimb_description;
	}

	public InputStream getReimb_recipt() {
		return reimb_recipt;
	}

	public void setReimb_recipt(InputStream reimb_recipt) {
		this.reimb_recipt = reimb_recipt;
	}

	public User getReimb_author() {
		return reimb_author;
	}

	public void setReimb_author(User reimb_author) {
		this.reimb_author = reimb_author;
	}

	public User getReimb_resolver() {
		return reimb_resolver;
	}

	public void setReimb_resolver(User reimb_resolver) {
		this.reimb_resolver = reimb_resolver;
	}

	public Status getReimb_status() {
		return reimb_status;
	}

	public void setReimb_status(Status reimb_status) {
		this.reimb_status = reimb_status;
	}

	public Type getReimb_type() {
		return reimb_type;
	}

	public void setReimb_type(Type reimb_type) {
		this.reimb_type = reimb_type;
	}

	
	
}