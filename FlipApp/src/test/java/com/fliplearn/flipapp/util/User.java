package com.fliplearn.flipapp.util;

public class User 
{
	private String role;
	private String board;
	private String className;
	private String roleType;
	private String subType;
	private String mobile;
	private String userName;
	private String password;

	public User(String role, String board, String className, String roleType, String subType, String mobile, String userName, String password)
	{
		this.role = role;
	    this.board = board;
	    this.className = className;
	    this.roleType = roleType;
	    this.subType = subType;
	    this.mobile = mobile;
	    this.userName = userName;
	    this.password = password;
	}

	public String getRole() 
	{
		return role;
	}
	
	public String getBoard() 
	{
		return board;
	}
	
	public String getClassName() 
	{
		return className;
	}
	
	public String getRoleType() 
	{
		return roleType;
	}
	public String getSubType() 
	{
		return subType;
	}
	
	public String getMobile() 
	{
		return mobile;
	}
	
	public String getuserName() 
	{
		return userName;
	}
	
	public String getPassword() 
	{
		return password;
	}
}
