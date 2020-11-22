package com.mutez.valot.web.jpa;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ManagedBean //permet de preciser au serveru que ce bean est dorenavant gerer par JSF
@RequestScoped // New bean is created for every request. Short-lived
@Entity
@Table(name="student")
public class Student1 {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "id")
	private int Id;
	@Column( name = "first_name")
	private String First_Name;
	@Column( name = "last_name")
	private String Last_Name;
	@Column( name = "email")
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
	
	/*public Student1(String first_Name, String last_Name, String email) {
		super();
		First_Name = first_Name;
		Last_Name = last_Name;
		Email = email;
	}
	
	public Student1(int id, String first_Name, String last_Name, String email) {
		super();
		Id = id;
		First_Name = first_Name;
		Last_Name = last_Name;
		Email = email;
	}
	
	public Student1() {
		super();
	}*/
	
	//Pas forcement utile mais c est copie coller
	@Override
	public String toString() {
		return "Student [Id=" + Id + ", First_Name=" + First_Name + ", Last_Name=" + Last_Name + ", Email=" + Email
				+ "]";
	}
}
