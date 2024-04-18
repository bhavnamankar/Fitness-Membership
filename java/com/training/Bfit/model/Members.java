package com.training.Bfit.model;
import java.util.*;

public class Members {
   private int member_Id;
   private List<Membership_Plans> plans;
   private String userName;
   private String password;
   private String fullName;
   private String email;
   private String address;
   private int age;
   private String phone_Number;
   private String gender;
   private Date registrationDate;
public int getMember_Id() {
	return member_Id;
}
public void setMember_Id(int member_Id) {
	this.member_Id = member_Id;
}
public List<Membership_Plans> getPlans() {
	return plans;
}
public void setPlans(List<Membership_Plans> plans) {
	this.plans = plans;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getFullName() {
	return fullName;
}
public void setFullName(String fullName) {
	this.fullName = fullName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getPhone_Number() {
	return phone_Number;
}
public void setPhone_Number(String phone_Number) {
	this.phone_Number = phone_Number;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public Date getRegistrationDate() {
	return registrationDate;
}
public void setRegistrationDate(Date registrationDate) {
	this.registrationDate = registrationDate;
}
@Override
public int hashCode() {
	return Objects.hash(address, age, email, fullName, gender, member_Id, password, phone_Number, plans,
			registrationDate, userName);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Members other = (Members) obj;
	return Objects.equals(address, other.address) && age == other.age && Objects.equals(email, other.email)
			&& Objects.equals(fullName, other.fullName) && Objects.equals(gender, other.gender)
			&& member_Id == other.member_Id && Objects.equals(password, other.password)
			&& Objects.equals(phone_Number, other.phone_Number) && Objects.equals(plans, other.plans)
			&& Objects.equals(registrationDate, other.registrationDate) && Objects.equals(userName, other.userName);
}
@Override
public String toString() {
	return "Members [member_Id=" + member_Id + ", plans=" + plans + ", userName=" + userName + ", password=" + password
			+ ", fullName=" + fullName + ", email=" + email + ", address=" + address + ", age=" + age
			+ ", phone_Number=" + phone_Number + ", gender=" + gender + ", registrationDate=" + registrationDate + "]";
}
public Members(int member_Id,List< Membership_Plans> plans, String userName, String password, String fullName, String email,
		String address, int age, String phone_Number, String gender, Date registrationDate) {
	super();
	this.member_Id = member_Id;
	this.plans = plans;
	this.userName = userName;
	this.password = password;
	this.fullName = fullName;
	this.email = email;
	this.address = address;
	this.age = age;
	this.phone_Number = phone_Number;
	this.gender = gender;
	this.registrationDate = registrationDate;
}
public Members() {
	super();
	
}

   
   
}
