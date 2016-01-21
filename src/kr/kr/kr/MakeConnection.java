package kr.kr.kr;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MakeConnection {
	private static DataSource dataFactory;
	
	private MakeConnection() {
		// TODO Auto-generated constructor stub
		Context ctx;
		try {
			ctx = new InitialContext();
			dataFactory = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			System.out.println(dataFactory);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	public static Connection GetConnection() throws SQLException{
		new MakeConnection();
		return dataFactory.getConnection();
	}
}
