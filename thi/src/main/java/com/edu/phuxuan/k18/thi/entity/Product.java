package com.edu.phuxuan.k18.thi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne
    @JoinColumn(name = "producttype_id")
    private ProductType producttype;
	
	public Product() {
			
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", producttype=" + producttype + "]";
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the producttype
	 */
	public ProductType getProducttype() {
		return producttype;
	}

	/**
	 * @param producttype the producttype to set
	 */
	public void setProducttype(ProductType producttype) {
		this.producttype = producttype;
	}
	

}