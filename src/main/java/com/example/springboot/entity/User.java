package com.example.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  //to make this class a JPA entity  
@Table(name= "users")   //to
public class User {
	
	@Id  //Pour montrer que c'est une clé primaire
	@GeneratedValue(strategy= GenerationType.AUTO)   //Auto-incrémentation pour l'Id
	private long id;
	
	@Column(name="first_name")   //Nom de la colonne dans la table de la DB
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	
	@Column(name="email")
	private String email;
	
	
	
	public User() {
		 
		 
	}
	
	
	
	public User(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}
