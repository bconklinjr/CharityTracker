/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CharityTracker;

import java.sql.*;

/**
 *
 * @author brian2
 */
public class DBEngine {
    private static String url;
    private static Connection conn;
    private static Statement query;
    
    DBEngine () {
        url = "jdbc:derby:CharityDB;ifexists=true";
        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(url);
            query = conn.createStatement();
        } catch (Exception e) {
            url = "jdbc:derby:CharityDB;create=true";
            try {
                conn = DriverManager.getConnection(url);
                query = conn.createStatement();
                BuildDB();
            } catch (Exception ex) {/*do nothing*/}
        }
    }
    
    private static void BuildDB () {
        try {
            String sql = "CREATE TABLE Donor" +
                    "( DonorID INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
                    "Name VARCHAR(50), " +
                    "Phone VARCHAR(10));";
            query.execute(sql);
            
            sql = "CREATE TABLE Charity" +
                    "( CharityID INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
                    "Name VARCHAR(50), " +
                    "TaxId VARCHAR(25));";
            query.execute(sql);
            
            sql = "CREATE TABLE Donations" +
                    "( DonationID INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
                    "DonorID INT, " +
                    "CharityID INT, " +
                    "DonationAmnt DOUBLE, " +
                    "Date VARCHAR(30), " +
                    "FOREIGN KEY (DonorID) REFERENCES Donor (DonorID), " +
                    "FOREIGN KEY (CharityID) REFERENCES Charity (CharityID));";
            query.execute(sql);
        } catch (Exception e) {/*do nothing*/}
        
    }
    
    public void AddDonation(Donor D) {
        
    }
    
    public void AddDonor (Donor D) {
        String sql = "INSERT INTO Donor VALUES" +
                "('" + D.getName() + "', '" + D.getPhone() + "');";
        try {
            query.executeUpdate(sql);
        } catch (Exception e) {/*do nothing*/}
        
    }
    
    public void AddCharity (Charity C) {
        String sql = "INSERT INTO Charity VALUES" +
                "('" + C.getName() + "', '" + C.getTaxId() + "');";
        try {
            query.executeUpdate(sql);
        } catch (Exception e) {/*do nothing*/}
    }
}
