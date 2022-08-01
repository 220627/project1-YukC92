package com.revature.models;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Timestamp;

public class Reimbursement {

	private int reimb_id;
	private int amount;
	private Timestamp submitted;
	private Timestamp resolved;
	private String description;
	private InputStream receipt;
	private User author;
	private User resolver;
	private Status status;
	private Type type;
	private int action;
	
	private int author_fk;
	private int resolver_fk;
	private int status_id_fk;
	private int type_id_fk;
	
	
	
	public Reimbursement(int reimb_id, int amount, String description, int author_fk, int type_id_fk) {
		super();
		this.reimb_id = reimb_id;
		this.amount = amount;
		this.description = description;
		this.author_fk = author_fk;
		this.type_id_fk = type_id_fk;
	}

	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Reimbursement(int reimb_id, int amount, Timestamp submitted, Timestamp resolved, String description,
			InputStream receipt, User author, User resolver, Status status, Type type, int action) {
		super();
		this.reimb_id = reimb_id;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.receipt = receipt;
		this.author = author;
		this.resolver = resolver;
		this.status = status;
		this.type = type;
		this.action = action;
	}
	
	public Reimbursement(int reimb_id, int amount, Timestamp submitted, Timestamp resolved, String description,
			InputStream receipt, int author_fk, int resolver_fk, int status_id_fk, int type_id_fk) {
		super();
		this.reimb_id = reimb_id;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.receipt = receipt;
		this.author_fk = author_fk;
		this.resolver_fk = resolver_fk;
		this.status_id_fk = status_id_fk;
		this.type_id_fk = type_id_fk;
	}
	
//	public Reimbursement(int reimb_id, int amount, Timestamp submitted, Timestamp resolved, String description,
//			InputStream receipt, User author, Status status, Type type) {
//		super();
//		this.reimb_id = reimb_id;
//		this.amount = amount;
//		this.submitted = submitted;
//		this.resolved = resolved;
//		this.description = description;
//		this.receipt = receipt;
//		this.author = author;
//		this.status = status;
//		this.type = type;
//	}
//	
//	public Reimbursement(int reimb_id, int amount, Timestamp submitted, Timestamp resolved, String description,
//			InputStream receipt, User resolver, Status status, int resolver_fk, int status_id_fk) {
//		super();
//		this.reimb_id = reimb_id;
//		this.amount = amount;
//		this.submitted = submitted;
//		this.resolved = resolved;
//		this.description = description;
//		this.receipt = receipt;
//		this.resolver = resolver;
//		this.status = status;
//		this.resolver_fk = resolver_fk;
//		this.status_id_fk = status_id_fk;
//	}

	public int getReimb_id() {
		return reimb_id;
	}

	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Timestamp getSubmitted() {
		return submitted;
	}

	public void setSubmitted(Timestamp submitted) {
		this.submitted = submitted;
	}

	public Timestamp getResolved() {
		return resolved;
	}

	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public InputStream getReceipt() {
		return receipt;
	}

	public void setReceipt(InputStream receipt) {
		this.receipt = receipt;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public User getResolver() {
		return resolver;
	}

	public void setResolver(User resolver) {
		this.resolver = resolver;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public int getAuthor_fk() {
		return author_fk;
	}

	public void setAuthor_fk(int author_fk) {
		this.author_fk = author_fk;
	}

	public int getResolver_fk() {
		return resolver_fk;
	}

	public void setResolver_fk(int resolver_fk) {
		this.resolver_fk = resolver_fk;
	}

	public int getStatus_id_fk() {
		return status_id_fk;
	}

	public void setStatus_id_fk(int status_id_fk) {
		this.status_id_fk = status_id_fk;
	}

	public int getType_id_fk() {
		return type_id_fk;
	}

	public void setType_id_fk(int type_id_fk) {
		this.type_id_fk = type_id_fk;
	}


	@Override
	public String toString() {
		return "Reimbursement [reimb_id=" + reimb_id + ", amount=" + amount + ", submitted=" + submitted + ", resolved="
				+ resolved + ", description=" + description + ", receipt=" + receipt + ", author=" + author
				+ ", resolver=" + resolver + ", status=" + status + ", type=" + type + ", action=" + action
				+ ", author_fk=" + author_fk + ", resolver_fk=" + resolver_fk + ", status_id_fk=" + status_id_fk
				+ ", type_id_fk=" + type_id_fk + "]";
	}

	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
	}
	
	


	
}
