package org.phptravel.usingtestng;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlDemo {
	
String url = "jdbc:mysql://localhost:3306/";
String driver = "com.mysql.jdbc.Driver";

String dbName = "agileitweekend";
String username = "root";
String password = "";
Connection conn;
String s;
public void connecttodatabase() {
try {
	conn = DriverManager.getConnection(url+dbName, username, password);
    System.out.println(conn.isClosed());
}catch (Exception e) {
	System.out.println("Unable to connect");
}
}
public String sendstatement() throws SQLException {
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery("select * from username");
    while(rs.next()) {
    s = rs.getString(1);
        }
	return s ;
}
}
   // PreparedStatement pstmt = conn.prepareStatement("select * from username where name =  ?");
    //pstmt.setString(1,"BOB");
    //ResultSet rs = pstmt.executeQuery();
    //while (rs.next()) {
    //System.out.println(rs.getString(1));
    	
 	


