package com.evergreenprogrammers.microservices.productcatalogservice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	Long id;
	@Column(name = "NAME")
	String name;
	@Column(name = "TYPE")
	String type;
	@Column(name = "PORT")
	private int port;

	public Product() {
		super();
	}

	public Product(String name, String type) {
		this();
		this.type = type;
		this.name = name;
	}

	public Product(String name, String type, int port) {
		this();
		this.type = type;
		this.name = name;
		this.port = port;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", type=" + type + ", port=" + port + "]";
	}

}