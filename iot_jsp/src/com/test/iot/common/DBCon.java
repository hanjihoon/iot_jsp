package com.test.iot.common;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class DBCon {
    public static Connection conn;
    public static Connection getCon() throws SQLException {
    	if(DBCon.conn == null || DBCon.conn.isClosed()) {

    		Context initContext;
    		try {
    		initContext = new InitialContext();
    		Context envContext = (Context)initContext.lookup("java:/comp/env");
    		DataSource ds = (DataSource)envContext.lookup("jdbc/IOT");
    		DBCon.conn = ds.getConnection();
    		}catch (NamingException | SQLException e) {
    			e.printStackTrace();
    		}
    	}
    	return DBCon.conn;
    	}
    
    public static void closeCon() throws SQLException {
    	DBCon.conn.close();
    }
    }

