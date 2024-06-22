package com.jdbc.model;

public class Product {
	int id;
	String Pname;
	int Price;

	public Product() {

	}

	public Product(int id, String pname, int price) {
		super();
		this.id = id;
		this.Pname = pname;
		this.Price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPname() {
		return Pname;
	}

	public void setPname(String pname) {
		Pname = pname;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", Pname=" + Pname + ", Price=" + Price + "]";
	}

}
