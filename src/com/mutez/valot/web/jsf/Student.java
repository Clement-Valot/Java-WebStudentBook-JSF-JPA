package com.mutez.valot.web.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean //permet de preciser au serveru que ce bean est dorenavant gerer par JSF
@RequestScoped // New bean is created for every request. Short-lived
public class Student {
	private int Id;
	private String First_Name;
	private String Last_Name;
	private String Email;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getFirst_Name() {
		return First_Name;
	}
	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}
	public String getLast_Name() {
		return Last_Name;
	}
	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	public Student(String first_Name, String last_Name, String email) {
		super();
		First_Name = first_Name;
		Last_Name = last_Name;
		Email = email;
	}
	
	public Student(int id, String first_Name, String last_Name, String email) {
		super();
		Id = id;
		First_Name = first_Name;
		Last_Name = last_Name;
		Email = email;
	}
	
	public Student() {
		super();
	}
}
