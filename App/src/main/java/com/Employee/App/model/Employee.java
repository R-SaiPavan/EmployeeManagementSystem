package com.Employee.App.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;




@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
   
   
	@Column(name = "first_name")
    @NotBlank(message = "enter your firstname")
    private String firstName;

    @Column(name = "last_name")
    @NotBlank(message = "enter your lastname")
    private String lastName;

    @Column(name = "email")
    @NotBlank(message = "enter your email")
    private String email;
    
    @Column(name = "designation")
    @NotBlank(message = "enter your designation")
    private String designation;
    
    @Column(name = "place")
    @NotBlank(message = "enter your place")
    private String place;
    
    @Column(name = "password")
    @NotBlank(message = "enter your password")
    private String password;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
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
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
    
}
