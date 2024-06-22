package com.jdbc.service;

import java.util.*;
import java.sql.*;

import com.jdbc.model.*;

public interface ProductService {
	void insertProduct(Product product) throws SQLException, ClassNotFoundException;

	void deleteProduct(int pid) throws SQLException, ClassNotFoundException;

	void updateProduct(int pid, Product product) throws SQLException, ClassNotFoundException;

	List<Product> getAllProduct() throws SQLException, ClassNotFoundException;

	Product getProduct(int pid) throws SQLException, ClassNotFoundException;
}
