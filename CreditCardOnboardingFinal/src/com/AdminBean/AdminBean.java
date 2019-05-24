package com.AdminBean;

public class AdminBean {
private String fname;
private String lname;
private String uid;
private String status;
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public String getUid() {
	return uid;
}
public void setUid(String uid) {
	this.uid = uid;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public AdminBean(String fname, String lname, String uid, String status) {
	
	this.fname = fname;
	this.lname = lname;
	this.uid = uid;
	this.status = status;
}

}
