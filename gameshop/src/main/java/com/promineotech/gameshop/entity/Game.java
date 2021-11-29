package com.promineotech.gameshop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Game {
    private int gameID;
    private int locationID;
    private boolean is_sold;
    private String make;
    private String model;
    private double price;
}
