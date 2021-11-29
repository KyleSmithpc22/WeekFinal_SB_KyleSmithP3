package com.promineotech.gameshop.controller;

import java.util.List;

import com.promineotech.gameshop.entity.Customer;
import com.promineotech.gameshop.entity.Employee;
import com.promineotech.gameshop.entity.Location;
import com.promineotech.gameshop.entity.Transaction;
import com.promineotech.gameshop.entity.Game;
import com.promineotech.gameshop.service.GameshopService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultGameshopController implements GameshopController{
    
    @Autowired
    private GameshopService gameshopService;

    
    //==========================Customers===============================================

    @Override
    @GetMapping("Customers")
    public ResponseEntity<List<Customer>> listCustomers(){
        log.info("customer list requested");
        List<Customer> customers = gameshopService.listCustomers();
        return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
    }
    
    // Insert operation on customers table
    @Override
    public void newCustomer(String name, String address, String phone){
        gameshopService.newCustomer(name, address, phone);
    }

    public void updateCustomer(int customerID, String name, String address, String phone){
        gameshopService.updateCustomer(customerID, name, address, phone);
    }

    // Delete operation on customers table
    public void deleteCustomer(int customerID){
        gameshopService.deleteCustomer(customerID);
    }
    

  //==========================Transactions===============================================

    @Override
    public ResponseEntity<List<Transaction>> getTransactions(int transactionID) {
        List<Transaction> transactions = gameshopService.getTransactions(transactionID);
        return new ResponseEntity<List<Transaction>>(transactions, HttpStatus.OK);
        
    }
    @Override
    public void deleteTransaction(int transactionID) {
        gameshopService.deleteTransaction(transactionID);
        
    }

    @Override
    public void updateTransaction(int transactionID, int gameID, int customerID, int employeeID, int locationID,
            String date) {
        gameshopService.updateTransaction(transactionID, gameID, customerID, employeeID, locationID, date);
        
    }

    @Override
    public void newTransaction(int gameID, int customerID, int employeeID, int locationID, String date) {
       gameshopService.newTransaction(gameID, customerID, employeeID, locationID, date);
        
    }
    
  //==========================Locations===============================================
    @Override
    public ResponseEntity<List<Location>> getLocation(int locationID) {
        List<Location> location = gameshopService.getLocation(locationID);
        return new ResponseEntity<List<Location>>(location, HttpStatus.OK);
    }

    @Override
    public void deleteLocation(int locationID) {
        gameshopService.deleteLocation(locationID);
        
    }

    @Override
    public void updateLocation(int locationID,
            String locationName) {
        gameshopService.updateLocation(locationID, locationName);
        
    }

    @Override
    public void newLocation(String locationName) {
       gameshopService.newLocation(locationName);
        
    }
    
    //==========================Employees===============================================

    @Override
    @GetMapping("Employees")
    public ResponseEntity<List<Employee>> listEmployees(){
        log.info("employee list requested");
        List<Employee> employees = gameshopService.listEmployees();
        return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
    }
    
   //@Override
    public void newEmployee(String name, int locationID){
        gameshopService.newEmployee(name, locationID);
    }

    public void updateEmployee(int employeeID, String name, int locationID){
        gameshopService.updateEmployee(employeeID, name, locationID);
    }

  
    public void deleteEmployee(int employeeID){
        gameshopService.deleteEmployee(employeeID);
    }


    //===========================Games==============================================
    @Override
    public ResponseEntity<List<Game>> getGame(int gameID) {
        List<Game> game = gameshopService.getGame(gameID);
        return new ResponseEntity<List<Game>>(game, HttpStatus.OK);
    }
   @Override
   public void deleteGame(int gameID) {
       gameshopService.deleteGame(gameID);
    }
   @Override
   public void updateGame(int gameID,int locationID, boolean is_sold, String gTitle, String console, double price) {
       gameshopService.updateGame(gameID, locationID, is_sold, gTitle, console, price);
   }
   @Override
   public void newGame(int locationID, boolean is_sold, String gTitle, String console, double price) {
   gameshopService.newGame(locationID, is_sold, gTitle, console, price);
}

}