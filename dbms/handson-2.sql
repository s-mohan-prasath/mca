-- CREATING TABLES
CREATE TABLE CLIENT(
    client_no char(6),
    name char(100) NOT NULL,
    city varchar(50),
    pincode char(6),
    bal_due NUMBER,
    PRIMARY KEY (client_no)
)
CREATE TABLE SALESMAN(
    salesman_no char(6),
    name varchar(100),
    PRIMARY KEY(salesman_no)
)

CREATE TABLE SALES_ORDER(
    order_no char(6),
    order_date DATE,
    client_no char(6),
    salesman_no char(6),
    delay_date date,
    order_status varchar(20),
    PRIMARY KEY (order_no),
    FOREIGN KEY (client_no) REFERENCES CLIENT(client_no),
    FOREIGN KEY (salesman_no) REFERENCES SALESMAN(salesman_no)
)

-- insert data into the table

INSERT INTO CLIENT VALUES ('&client_no','&name','&city','&pincode','&bal_due');
INSERT INTO SALESMAN VALUES ('&salesman_no','&name');
INSERT INTO sales_order VALUES ('&order_no','&order_date','&client_no','&salesman_no','&delay_date','&order_status');

-- Executing the sql commands

--List all details from the client_master table for clients whose Bal_due = 0.
--List all details from the client_master table for clients whose Bal_due higher than  5000. 
--List all details from the client_master table for clients whose Bal_due between 5000 and 20000. 
--Display all clients who are coming from city starts with ‘C’ and ‘D’
--Display all clients whose pincode end with 1.
--Update table client_master, Change city of Client_no C00004 to Jaipur.
--Fetch the clients records whose order status is in cancelled 
--Retrieve records of clients residing in Mumbai.
--Find the name and address of customer who has placed Order_no 'O19003' and 'O19002' respectively.
--Construct English like sentence from the table client_master ({Customer name} live in the city of {city}).
--List the client_no, name, city and pincode of clients whose Order_status is "In process".


SELECT * FROM CLIENT WHERE bal_due = 0;

SELECT * FROM CLIENT WHERE bal_due > 5000;

SELECT * FROM CLIENT WHERE bal_due > 5000 AND bal_due < 20000;

SELECT * FROM CLIENT WHERE city LIKE 'C%' OR city LIKE 'D%';

SELECT * FROM CLIENT WHERE pincode LIKE '%1';

UPDATE CLIENT SET city = 'Jaiper' WHERE client_no = 'C00004';
SELECT * FROM CLIENT;

SELECT * FROM CLIENT WHERE client_no in (SELECT DISTINCT client_no FROM SALES_ORDER WHERE order_status = 'CANCELLED');

SELECT * FROM CLIENT WHERE city = 'Mumbai';

SELECT name,city FROM CLIENT WHERE client_no in (SELECT client_no FROM SALES_ORDER WHERE order_no = 'O19003' OR order_no = 'O19002');

SELECT name||' live in the city of '||city AS sentence FROM CLIENT;

SELECT client_no,name,city,pincode FROM CLIENT WHERE client_no in (SELECT client_no from sales_order where order_status = 'PROGRESS');

commit