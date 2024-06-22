package com.jdbc.client;

import com.jdbc.model.*;
import com.jdbc.service.*;
import java.sql.*;
public class ProductClient {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		ProductService ps = new ProductServiceImpl();

		ps.insertProduct(new Product(123, "Dell Laptop", 51500));
		ps.insertProduct(new Product(124, "LED TV", 40400));
		ps.insertProduct(new Product(125, "Refrigerator", 30000));

		ps.getAllProduct().stream().forEach(p -> System.out.println(p));

	}

}
