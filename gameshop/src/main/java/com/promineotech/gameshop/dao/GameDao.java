package com.promineotech.gameshop.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.promineotech.gameshop.entity.Game;

import org.springframework.stereotype.Service;

@Service
public class GameDao {
    private static final String HOSTNAME = "jdbc:mysql://localhost:3306/gameshop?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

     public List<Game> getGame(Integer gameID) {
    	   final String getGame = "SELECT * FROM games where gameID = ?";
    	   
    	   try(
    			   Connection connection = DriverManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
    			   
    			      PreparedStatement preparedStatement = connection.prepareStatement(getGame);
    			     
    			   
    			   ){
    		   preparedStatement.setInt(1, gameID);
    		   
    		   ResultSet rs = preparedStatement .executeQuery();
    		   List<Game> list = new ArrayList<>();
    		   while (rs.next()) {
    			   int game_id = rs.getInt("gameID");
    			   int locationID = rs.getInt("locationID");
    			   boolean is_sold = rs.getBoolean("is_sold");
    			   String gTitle = rs.getString("gTitle");
    			   String console = rs.getString("console");
    			   double price = rs.getDouble("price");
    			   Game game = new Game(game_id, locationID, is_sold, gTitle, console, price);
    			   list.add(game);
    		   }
    		   return list;
    	   } catch (SQLException e) {
    		  printSQLException(e);
    		   return Collections.emptyList();
    	   }
       }
       
      
       public void newGame(int locationID, boolean is_sold, String gTitle, String console, double price) {
    	   final String updateGame = "INSERT into games (locationID, is_sold, gTitle, console, price)" +
       "Values (?,?,?,?,?);";
    	   
    	   try(
    		  Connection connection = DriverManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
    			   
    			   PreparedStatement preparedStatement = connection.prepareStatement(updateGame)){
    		   preparedStatement.setInt(1,locationID);
    		   preparedStatement.setBoolean(2, is_sold);
    		   preparedStatement.setString(3, gTitle);
    		   preparedStatement.setString(4, console);
    		   preparedStatement.setDouble(5, price);
    		   
    		   preparedStatement.executeUpdate();   	
  	   }catch (SQLException e) {
  		   printSQLException(e);
  	   }
       }
       public void updateGame(int gameID, int gameshopID, boolean is_sold, String gTitle, String console, double price) {
   		final String updateGame = "Update games set locationID = ?, is_sold = ?, gTitle = ?, console = ?, price = ?" +
   	"where gameID = ?;";
   		
   		try(
   		   Connection connection = DriverManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
   				
   			PreparedStatement preparedStatement = connection.prepareStatement(updateGame)){
   			
   			preparedStatement.setInt(1,gameshopID);
   			preparedStatement.setBoolean(2, is_sold);
   			preparedStatement.setString(3, gTitle);
   			preparedStatement.setString(4, console);
   			preparedStatement.setDouble(5, price);
   			preparedStatement.setInt(6, gameID);
   			
   			preparedStatement.executeUpdate();   	
   	  }catch (SQLException e) {
   		  printSQLException(e);
   	  }
   	}
       public void deleteGame(Integer gameID) {
    	   final String getGames = "DELETE FROM games where gameID = ?;";
    	   
    	   try(
    			   Connection connection = DriverManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
    			   
    			   PreparedStatement preparedStatement = connection.prepareStatement(getGames);
    			 
    			   ){
    		   preparedStatement.setInt(1, gameID);
    		   
    		   int result = preparedStatement.executeUpdate();
    		   System.out.println("Number of game records affected ::" + result);
    	   }catch (SQLException e) {
    		   printSQLException(e);
    	   }
    	   
    	   
    	   }
       public static void printSQLException(SQLException ex) {
    	   for(Throwable e :ex) {
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