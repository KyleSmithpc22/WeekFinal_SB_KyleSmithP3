package com.promineotech.gameshop.dao;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.promineotech.gameshop.entity.Location;

import org.springframework.stereotype.Service;

@Service
public class LocationDao {
    private static final String HOSTNAME = "jdbc:mysql://localhost:3306/gameshop?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
	
	//getLocation method- get a location by id
    public List<Location> getLocation(Integer locationID){
        final String getLocation = "SELECT * FROM locations where locationID = ?";

        try (
            Connection connection = DriverManager.getConnection(HOSTNAME, USERNAME, PASSWORD);

                
                    PreparedStatement preparedStatement = connection.prepareStatement(getLocation);
                    
            ) {
                preparedStatement.setInt(1, locationID);
            
            ResultSet rs = preparedStatement.executeQuery();
            List<Location> list = new ArrayList<>();
            while (rs.next()) {
                int location_ID = rs.getInt("locationID");
                String locationName = rs.getString("location_name");
              
                Location location = new Location(location_ID, locationName);
                list.add(location);
            }
            return list;
        } catch (SQLException e) {
            printSQLException(e);
            return Collections.emptyList();
        } 
    }

    
    public void newLocation( String locationName) {
         
        final String updateTransaction = "INSERT into locations (location_name) Values (?);";

        

        try (
            Connection connection = DriverManager.getConnection(HOSTNAME, USERNAME, PASSWORD);

                
                PreparedStatement preparedStatement = connection.prepareStatement(updateTransaction)) {
                    preparedStatement.setString(1, locationName);


            

            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            
            printSQLException(e);
        }
    }


    public void updateLocation(int locationID, String locationName) {
         
        final String updateLocation = "update locations set location_name = ? where locationID = ?;";

        

        try (
            Connection connection = DriverManager.getConnection(HOSTNAME, USERNAME, PASSWORD);

                
                PreparedStatement preparedStatement = connection.prepareStatement(updateLocation)) {
                    preparedStatement.setInt(2, locationID);
                    preparedStatement.setString(1, locationName);
                

            

            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            
            printSQLException(e);
        }
    }


    public void deleteLocation(Integer locationID){
        final String getTransaction = "DELETE FROM locations where locationID = ?;";

        try (
            Connection connection = DriverManager.getConnection(HOSTNAME, USERNAME, PASSWORD);

                
                    PreparedStatement preparedStatement = connection.prepareStatement(getTransaction);
                    
            ) {
                preparedStatement.setInt(1, locationID);
            
            int result = preparedStatement.executeUpdate();
            System.out.println("Number of location records affected :: " + result);
        } catch (SQLException e) {
            printSQLException(e);
        } 
    }




    public static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }


}