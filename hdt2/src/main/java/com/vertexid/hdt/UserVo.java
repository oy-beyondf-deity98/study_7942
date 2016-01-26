package com.vertexid.hdt;

public class UserVo {

private String userId;
private String userName;
private String extAuth;
private String passwordHash;
private String role;


public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getExtAuth() {
	return extAuth;
}
public void setExtAuth(String extAuth) {
	this.extAuth = extAuth;
}
public String getPasswordHash() {
	return passwordHash;
}
public void setPasswordHash(String passwordHash) {
	this.passwordHash = passwordHash;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}



}
