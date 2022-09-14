package com.maveric.jdbc;

import java.sql.*;

public class ConnectionManager {
	
	private static Connection con = null;
	static {
		String url = "jdbc:mysql://localhost:3306/ebookshop";
		String user = "root";
		String password = "Password@123";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		return con;
	}
	public static void closeConnection(Connection conn) {

        try 
        {
            conn.close();
        } 
        catch (SQLException e) 
        {
        	e.printStackTrace();
        }
    }
	public static void main(String args[]) {
		
		Connection con = ConnectionManager.getConnection();
		ResultSet rs = null;
		Statement st = null;
		try {
			if(con!=null) {
				System.out.println("Connected Successfully!!");
			st = con.createStatement();
			String query = "SELECT * FROM books;";
			
			rs = st.executeQuery(query);
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "
								+rs.getString(2)+" "
								+rs.getString(3)+" "
								+rs.getFloat(4)+" "
								+rs.getInt(5));
			}
			}
			ConnectionManager.closeConnection(con);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
            try {
                if (rs != null)
                    rs.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (st != null)
                    st.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            if (con != null) {
                ConnectionManager.closeConnection(con);
                System.out.println("Closed!!");
            }
		}
	}
}
