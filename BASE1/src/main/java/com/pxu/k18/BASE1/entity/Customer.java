package com.pxu.k18.BASE1.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;  

    
    @Column(name = "fullname")
    private String fullname;

    @Column(name = "birtday")
    private String birtday;	
    
    
    @Column(name = "sex")
    private String sex;
    
    @NotEmpty(message = "Phone may not be null")
    @Pattern(regexp="(^$|[0-9]{10})") 
    @Column(name = "phone")
    private String phone;
    
    @Column(name = "cmnd")
    private int cmnd;
    
    @NotEmpty(message = "Email may not be null")
    @Column(name = "email")
    private String email;
    
    @Column(name = "address")
    private String address;
    
    @ManyToOne
    @JoinColumn(name="customer_id")
     private CustomerType customerType;  
    
    public Customer() {

    }

	public Customer(int id, String fullname, String birtday, String sex, String phone, int cmnd, String email,
			String address, CustomerType customerType) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.birtday = birtday;
		this.sex = sex;
		this.phone = phone;
		this.cmnd = cmnd;
		this.email = email;
		this.address = address;
		this.customerType = customerType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getBirtday() {
		return birtday;
	}

	public void setBirtday(String birtday) {
		this.birtday = birtday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getCmnd() {
		return cmnd;
	}

	public void setCmnd(int cmnd) {
		this.cmnd = cmnd;
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

	public CustomerType getCustomerType() {
		return customerType;
	}

	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}

	 
    
 
}
