package com.project.example.domain;

public class Comment {

	private int c_id;
	private int commentB_id;
	private String c_contetn;
	private String c_writer;
	private String c_date;
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public int getCommentB_id() {
		return commentB_id;
	}
	public void setCommentB_id(int commentB_id) {
		this.commentB_id = commentB_id;
	}
	public String getC_contetn() {
		return c_contetn;
	}
	public void setC_contetn(String c_contetn) {
		this.c_contetn = c_contetn;
	}
	public String getC_writer() {
		return c_writer;
	}
	public void setC_writer(String c_writer) {
		this.c_writer = c_writer;
	}
	public String getC_date() {
		return c_date;
	}
	public void setC_date(String c_date) {
		this.c_date = c_date;
	}
	
	
}
