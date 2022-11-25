package com.pxu.k18.BASE1.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customertype")
public class CustomerType {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private int id;  

	 	@Column(name = "name")
	    private String name;
	 	
	 	@OneToMany(mappedBy = "customerType")
		private List <Customer> customers  ;

		public CustomerType() {
			super();
			 
		}

		public CustomerType(int id, String name, List<Customer> customers) {
			super();
			this.id = id;
			this.name = name;
			this.customers = customers;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<Customer> getCustomers() {
			return customers;
		}

		public void setCustomers(List<Customer> customers) {
			this.customers = customers;
		}
	 	
}
