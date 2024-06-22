package com.jdbc.service;

import java.sql.*;

import java.util.*;
import com.jdbc.model.*;
import com.jdbc.util.*;

public class ProductServiceImpl implements ProductService {
	@Override
	public void insertProduct(Product product) throws SQLException, ClassNotFoundException {

		PreparedStatement pst = DBConnection.getConnection().prepareStatement("insert into product values(?,?,?)");
		pst.setInt(1, product.getId());
		pst.setString(2, product.getPname());
		pst.setInt(3, product.getPrice());
		pst.execute();
	}

	@Override
	public void deleteProduct(int id) throws SQLException, ClassNotFoundException {
		PreparedStatement pst = DBConnection.getConnection().prepareStatement("delete from product where id=?");
		pst.setInt(1, id);
		pst.execute();

		System.out.println("Deleted");
	}

	public void updateProduct(int id, Product product) throws SQLException, ClassNotFoundException {
		Connection con = DBConnection.getConnection();
		con.setAutoCommit(false);
		try {
			PreparedStatement pst = con.prepareStatement("update product pname=?,price=? where id=?");
			pst.setInt(3, id);
			pst.setString(2, product.getPname());
			pst.setInt(3, product.getPrice());
			pst.execute();
		} catch (Exception e) {
			con.rollback();
		}
		con.commit();
		System.out.println("Deleted");
	}

	public List<Product> getAllProduct() throws SQLException, ClassNotFoundException {
		Statement st = DBConnection.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = st.executeQuery("select * from employee");
		List<Product> plist = new ArrayList<>();
		while (rs.next()) {

			Product p = new Product();
			p.setId(rs.getInt(1));
			p.setPname(rs.getString(2));
			p.setPrice(rs.getInt(3));
			plist.add(p);
		}
		return plist;
	}

	public Product getProduct(int id) throws SQLException, ClassNotFoundException {
		PreparedStatement st = DBConnection.getConnection().prepareStatement("select * from product where id=?");
		st.setInt(1, id);

		ResultSet rs = st.executeQuery();
		Product p = new Product();

		while (rs.next()) {
			p.setId(rs.getInt(1));
			p.setPname(rs.getString(2));
			p.setPrice(rs.getInt(3));

		}
		return p;
	}

}
