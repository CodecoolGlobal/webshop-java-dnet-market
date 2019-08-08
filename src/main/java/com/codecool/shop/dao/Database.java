package com.codecool.shop.dao;

import java.sql.*;

public class Database {
    // JDBC driver name and database URL

    static final String DB_URL = "jdbc:postgresql://localhost:5432/codecoolshop";
    //  Database credentials
    static final String USER = "kruppa";
    static final String PASS = "new_password";
    static Connection conn;
    static Statement stmt;

    public Database(){
        conn = null;
        stmt = null;
    }

    public static void executeQuery(String query){
        try{
            //STEP 2: Register JDBC driver

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = ((Connection) conn).createStatement();
            int rs = stmt.executeUpdate(query);

            //STEP 6: Clean-up environment
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try

    }
}