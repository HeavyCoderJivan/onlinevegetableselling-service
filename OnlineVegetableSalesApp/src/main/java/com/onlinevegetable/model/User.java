package com.onlinevegetable.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
@Entity
public class User
{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int userId;
@NotBlank(message="Username i mandatory")
private String userName;
private long mobileNumber;
private String emailId;
private String password;
private String confirmPassword;
public User(){}
public User(int userId, String userName, long mobileNumber, String emailId, String password, String confirmPassword) {
	super();
	this.userId = userId;
	this.userName = userName;
	this.mobileNumber = mobileNumber;
	this.emailId = emailId;
	this.password = password;
	this.confirmPassword = confirmPassword;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) 
{
	this.userId = userId;
}
public String getUserName()
{
	return userName;
}
public void setUserName(String userName)
{
	this.userName = userName;
}
public long getMobileNumber() 
{
	return mobileNumber;
}
public void setMobileNumber(long mobileNumber) {
	this.mobileNumber = mobileNumber;
}
public String getEmailId() 
{
	return emailId;
}
public void setEmailId(String emailId)
{
	this.emailId = emailId;
}
public String getPassword()
{
	return password;
}
public void setPassword(String password)
{
	this.password = password;
}
public String getConfirmPassword()
{
	return confirmPassword;
}
public void setConfirmPassword(String confirmPassword) 
{
	this.confirmPassword = confirmPassword;
}










}
