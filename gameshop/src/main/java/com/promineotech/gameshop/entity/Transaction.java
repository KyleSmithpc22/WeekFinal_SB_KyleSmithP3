package com.promineotech.gameshop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    private int transactionID;
    private int gameID;
    private int customerID;
    private int employeeID;
    private int locationID;
    private String dateStamp;
}
