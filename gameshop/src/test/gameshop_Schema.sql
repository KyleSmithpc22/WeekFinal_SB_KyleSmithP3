create DATABASE if not exists gamestop; 

use gamestop; 

drop table if exists transactions; 

drop table if exists employees; 

drop table if exists games; 

drop table if exists locations; 

drop table if exists customers; 

CREATE TABLE customers ( 

  customerID int (10) NOT NULL AUTO_INCREMENT, 

  name varchar(45), 

  address varchar(45), 

  phone varchar(20), 

  PRIMARY KEY (customerID) 

); 

CREATE TABLE locations ( 

locationID int(3) NOT NULL AUTO_INCREMENT, 

location_name varchar(40) NOT NULL, 

PRIMARY KEY (locationID)  

); 

CREATE TABLE games ( 

  gameID int (10) NOT NULL AUTO_INCREMENT, 

  locationID int (3) NOT NULL, 

  is_sold bit NOT NULL, 

  price decimal(7, 2) NOT NULL, 

  gTitle varchar(40) NOT NULL, 

  console varchar(40) NOT NULL, 

  PRIMARY KEY (vehicleID), 

  FOREIGN KEY (locationID) REFERENCES locations(locationID) 

); 

CREATE TABLE employees ( 

employeeID int(5) NOT NULL AUTO_INCREMENT, 

locationID int(3) NOT NULL, 

name varchar(40) NOT NULL, 

PRIMARY KEY (employeeID), 

FOREIGN KEY (locationID) REFERENCES locations(locationID) 

); 

create table transactions ( 

  transactionID int (10) NOT NULL AUTO_INCREMENT, 

  gameID int (10) NOT NULL, 

  customerID int(10) NOT NULL, 

  employeeID int(5) NOT NULL, 

  locationID int(3) NOT NULL, 

  datestamp date not null, 

  PRIMARY KEY (transactionID), 

  FOREIGN KEY (vehicleID) REFERENCES vehicles(vehicleID) , 

  FOREIGN KEY (customerID) REFERENCES customers(customerID), 

  FOREIGN KEY (employeeID) REFERENCES employees(employeeID), 

  FOREIGN KEY (locationID) REFERENCES locations(locationID) 

); 

  

   

  -- customers DATA, 5 records minimum 

INSERT INTO customers (name, address, phone) VALUES('Ashton_Barker', '9999_Notreal_Ln_ Concord_NH_11111', '111.222.3333');   

INSERT INTO customers (name, address, phone) VALUES('Zachary_Fisher', '8888_Fake_ Boston_MA_22222', '444.555.6666');   

INSERT INTO customers (name, address, phone) VALUES('Callum_Perry', '6565_Lies_St_ Montpellier_VT_33333', '777.888.9999');   

INSERT INTO customers (name, address, phone) VALUES('Kelly_Cote', '1001_404_St_ Augusta_ME_44444', '111.444.7777');   

INSERT INTO customers (name, address, phone) VALUES('Tobias_Wilder', '1134_idk_Rd_ Hartford_CO_55555', '222.555.8888');   

 

  

-- locations DATA, 2 records minimum 

INSERT INTO locations (locationID, location_name) VALUES('1', 'Boston');   

INSERT INTO locations (locationID, location_name) VALUES('2', 'Concord'); 

  

-- games DATA, 4 records minimum 

INSERT INTO games (locationID, copies, price, gTitle, console) VALUES(1, 0, '5509000', 'halo', 'Xbox');   

 INSERT INTO games (locationID, copies, price, gTitle, console) VALUES(1, 0, '5309000', 'sly_cooper', 'PS5');   

INSERT INTO games (locationID, copies, price, gTitle, console) VALUES(2, 0, '5690000', '7_daysToDie', 'PC');   

 INSERT INTO games (locationID, copies, price, gTitle, console) VALUES(2, 0, '9305000', 'Mario', 'Switch');    

 

  

  

-- employees DATA, 3 records minimum 

 

INSERT INTO employees (employeeID, locationID, name) VALUES('2', '2', 'June_Lyons');   

 INSERT INTO employees (employeeID, locationID, name) VALUES('3', '1', 'Kassidy_Hardin'); 

INSERT INTO employees (employeeID, locationID, name) VALUES('3', '1', ' Zac_Chapman');  

  

  

-- transactions DATA, 3 records minimum 

INSERT INTO transactions (vehicleID, customerID, employeeID, locationID, datestamp) VALUES('4',2, '4', '3',curdate()); 

INSERT INTO transactions (vehicleID, customerID, employeeID, locationID, datestamp) VALUES('2',4, '4', '3',curdate()); 

INSERT INTO transactions (vehicleID, customerID, employeeID, locationID, datestamp) VALUES('3',3, '4', '4',curdate()); 

 