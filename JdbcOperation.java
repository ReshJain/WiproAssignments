package com.jdbc;
import java.sql.*;
public class JdbcOperation {
 public static void main(String[] args)throws SQLException, ClassNotFoundException {
	Class.forName("oracle.jdbc.driver.Oracledriver");
	Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:9501/XE","system","rps@123");
	System.out.println("connection is succeed");
	Statement state = connection.createStatement();
	
	state.executeQuery("Create table product2 (prodId number(5) primary key, Name varchar(20) not null, Price number(7,2)");
	System.out.println("Created successfully ");
	
	state.executeUpdate("Insert into product2 values(1,'AC',50000.00)");
	state.executeUpdate("Insert into product2 values(2,'Fan',5000.00)");
	state.executeUpdate("Insert into product2 values(3,'Refridgerator',30000.00)");
	state.executeUpdate("Insert into product2 values(4,'Microwave',3000.00)");
	System.out.println("Insert Successfully");
	
	state.executeUpdate("delete from product2 where prodId = 3");
	System.out.println("Deleted Successfully");
	
	ResultSet rs = state.executeQuery("Select * from product");
	
	ResultSetMetaData rsm = rs.getMetaData();
	
	for(int i = 1; i<=rsm.getColumnCount(); i++) {
		System.out.print(rsm.getColumnName(i) + " ");
	}
	System.out.println();
	
	while(rs.next()) {
		System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
	}
	
	connection.close();
}
}
