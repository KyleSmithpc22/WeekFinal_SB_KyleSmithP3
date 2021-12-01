package com.promineotech.gameshop.controller;

import java.util.List;

import com.promineotech.gameshop.entity.Customer;
import com.promineotech.gameshop.entity.Employee;
import com.promineotech.gameshop.entity.Location;
import com.promineotech.gameshop.entity.Transaction;
import com.promineotech.gameshop.entity.Game;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/Gameshops")
public interface GameshopController {
    
    //==========================Customers===============================================

    /**
     * Customer Handlers
     * @return
     */
    @GetMapping("Customers")
    ResponseEntity<List<Customer>> listCustomers();
    
    // Insert customer
    @PostMapping("Customers")
    @ResponseStatus(code = HttpStatus.OK)
    void newCustomer(
        @RequestParam(required = true) String name,
        @RequestParam(required = true) String address, 
        @RequestParam(required = true) String phone);

    @PutMapping("Customers")
    @ResponseStatus(code = HttpStatus.OK)
    void updateCustomer(
        @RequestParam(required = true) int customerID, 
        @RequestParam(required = true) String name,
        @RequestParam(required = true) String address, 
        @RequestParam(required = true) String phone);


    
    @DeleteMapping("Customers")
    @ResponseStatus(code = HttpStatus.OK)
    void deleteCustomer(
        @RequestParam(required = true) int customerID);

    //==========================Transactions===============================================

    /**
     * Transaction handlers 
     * @param transactionID
     * @return
     */
    @GetMapping("Transactions")
    @ResponseStatus(code = HttpStatus.OK)
    ResponseEntity<List<Transaction>> getTransactions(
        @RequestParam(required = true) int transactionID
    );

    @DeleteMapping("Transactions")
    @ResponseStatus(code = HttpStatus.OK)
    void deleteTransaction(
        @RequestParam(required = true) int transactionID
    );

    @PostMapping("Transactions")
    @ResponseStatus(code = HttpStatus.OK)
    void newTransaction( 
        @RequestParam(required = true) int gameID, 
        @RequestParam(required = true) int customerID, 
        @RequestParam(required = true) int employeeID, 
        @RequestParam(required = true) int locationID, 
        @RequestParam(required = true) String date);

    @PutMapping("Transactions")
    @ResponseStatus(code = HttpStatus.OK)
    void updateTransaction(
        @RequestParam(required = true) int transactionID, 
        @RequestParam(required = true) int gameID, 
        @RequestParam(required = true) int customerID, 
        @RequestParam(required = true) int employeeID, 
        @RequestParam(required = true) int locationID, 
        @RequestParam(required = true) String date);


//==========================Locations===============================================

/**
 * Location handlers 
 * @param locationID
 * @return
 */
@GetMapping("Locations")
@ResponseStatus(code = HttpStatus.OK)
ResponseEntity<List<Location>> getLocation(
    @RequestParam(required = true) int locationID
);

@DeleteMapping("Locations")
@ResponseStatus(code = HttpStatus.OK)
void deleteLocation(
    @RequestParam(required = true) int locationID
);

@PostMapping("Locations")
@ResponseStatus(code = HttpStatus.OK)
void newLocation( 
    @RequestParam(required = true) String locationName);

@PutMapping("Locations")
@ResponseStatus(code = HttpStatus.OK)
void updateLocation(
    @RequestParam(required = true) int locationID, 
    @RequestParam(required = true) String locationName);

//==========================Employee===============================================


@GetMapping("Employees")
ResponseEntity<List<Employee>> listEmployees();


@PostMapping("Employees")
@ResponseStatus(code = HttpStatus.OK)
void newEmployee(
    @RequestParam(required = true) String name,
    @RequestParam(required = true) int locationID);
   

@PutMapping("Employees")
@ResponseStatus(code = HttpStatus.OK)
void updateEmployee(
    @RequestParam(required = true) int employeeID, 
    @RequestParam(required = true) String name,
    @RequestParam(required = true) int locationID);


@DeleteMapping("Employees")
@ResponseStatus(code = HttpStatus.OK)
void deleteEmployee(
    @RequestParam(required = true) int employeeID);



//========================Games========================================

  /**
   *  Game handlers
   *  @param gameID
   *  @return
   */
  @GetMapping("Games")
  @ResponseStatus(code = HttpStatus.OK)
  ResponseEntity<List<Game>> getGame(
          @RequestParam(required = true) int gameID
  );

  @DeleteMapping("Games")
  @ResponseStatus(code = HttpStatus.OK)
  void deleteGame(
          @RequestParam(required = true) int gameID);



  @PostMapping("Games")
  @ResponseStatus(code = HttpStatus.OK)
  void newGame(
          @RequestParam(required = true) int locationID,
          @RequestParam(required = true) boolean is_sold,
          @RequestParam(required = true) String gTitle,
          @RequestParam(required = true) String console,
          @RequestParam(required = true) double price);

  @PutMapping("Games")
  @ResponseStatus(code = HttpStatus.OK)
  void updateGame(
          @RequestParam(required = true) int gameID,
          @RequestParam(required = true) int locationID,
          @RequestParam(required = true) boolean is_sold,
          @RequestParam(required = true) String gTitle,
          @RequestParam(required = true) String console,
          @RequestParam(required = true) double price);

} // end GameshopController Interface