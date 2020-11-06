/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.edu.unsw.business.infs2605.W4E1IndiefyLoginScreen;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Database 
{
    
    
    public void initialise () throws SQLException
    {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db");
        Statement st = conn.createStatement();
        
        String query = "CREATE TABLE IF NOT EXISTS Users "
                + "("
                + "ID INTEGER PRIMARY KEY autoincrement, "
                + "username TEXT NOT NULL, "
                + "password TEXT NOT NULL "
                + ");";       
        st.execute(query);
        
        String queryOne = "CREATE TABLE IF NOT EXISTS Tracks "
                + "("
                + "supplierID INTEGER PRIMARY KEY autoincrement, "
                + "suppliername TEXT NOT NULL, "
                + "address TEXT NOT NULL, "
                + "phone INTEGER NOT NULL "
                + ");";
                
        st.execute(queryOne);       
        System.out.print("yesssssss");

               
        st.close();
        conn.close();
    }
    
    public void insertLogin() throws SQLException
    {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db");
        Statement st = conn.createStatement();        
        
        String insertUser11 = "INSERT OR IGNORE INTO Users (ID, USERNAME, PASSWORD) "
            + "VALUES (1, 'Pretentious', 'Hipster');";
        st.execute(insertUser11);
        
        String insertUser22 = "INSERT OR IGNORE INTO Users (ID, USERNAME, PASSWORD) "
            + "VALUES (2, 'P', 'H');";
        st.execute(insertUser22);        
        
        String insertUser33 = "INSERT OR IGNORE INTO Users (ID, USERNAME, PASSWORD) "
            + "VALUES (3, 'A', 'B');";
        st.execute(insertUser33);       
        
	st.close();
	conn.close();
    }
    
    public boolean loginCheck(String username, String password) throws SQLException
    {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db");
        Statement st = conn.createStatement();
        
        String getUsers = "SELECT * FROM Users WHERE USERNAME = '" + username + "' AND PASSWORD = '" + password + "'";
        ResultSet rs = st.executeQuery(getUsers);
        
        boolean success = true; 
        
        if(rs.next())
        {
            st.close();
            conn.close();
            return success = true;
        }
             
        else
        {
            st.close();
            conn.close();
            return success = false;
        }
    } 
              
    
    public void insertTracks() throws SQLException
    {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db");
        Statement st = conn.createStatement();
        
        String insertTrack11 = "INSERT OR IGNORE INTO Tracks (supplierID, SUPPLIERNAME, ADDRESS, PHONE) "
                + "VALUES (1,'Supplier 1', '1 High Street ', '029000000');";
        st.execute(insertTrack11);
        System.out.println("y");
        
        
        String insertTrack22 = "INSERT OR IGNORE INTO Tracks (supplierID, SUPPLIERNAME, ADDRESS, PHONE) "
                + "VALUES (2,'Supplier 2', '2 Low Street', '0291000000');";
        st.execute(insertTrack22);
        System.out.println("y1");

        String insertTrack33 = "INSERT OR IGNORE INTO Tracks (supplierID, SUPPLIERNAME, ADDRESS, PHONE) "
                + "VALUES (3,'Supplier 3', '10 Middle Street', '0292000000');";
        st.execute(insertTrack33);
        System.out.println("y3");
                

        
        st.close();
	conn.close();
          
    }
    
    
    public ObservableList<Tracks> getTracks() throws SQLException
    {
        
        Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db");
        Statement st = conn.createStatement();        
                
        String getTracks = "SELECT * FROM Tracks;*";
        ResultSet rs = st.executeQuery(getTracks);
        
        ObservableList<Tracks> trackList = FXCollections.observableArrayList();
        
        while(rs.next())
        {
            trackList.add(new Tracks (rs.getInt("supplierID"), rs.getString("suppliername"), rs.getString("address"), rs.getInt("phone")));
        }
        
        st.close();
        conn.close();
        return trackList;
        
    }

    
    
}
