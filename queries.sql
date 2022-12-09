postgres=> \l
                                                                     List of databases
          Name           |       Owner       | Encoding |  Collate   |   Ctype    | ICU Locale | Locale Provider |            Access privileges
-------------------------+-------------------+----------+------------+------------+------------+-----------------+-----------------------------------------
 cloudsqladmin           | cloudsqladmin     | UTF8     | en_US.UTF8 | en_US.UTF8 |            | libc            |
 customer                | cloudsqlsuperuser | UTF8     | en_US.UTF8 | en_US.UTF8 |            | libc            |
 employee                | postgres          | UTF8     | en_US.UTF8 | en_US.UTF8 |            | libc            |
 javalateralassignment_2 | cloudsqlsuperuser | UTF8     | en_US.UTF8 | en_US.UTF8 |            | libc            |
 postgres                | cloudsqlsuperuser | UTF8     | en_US.UTF8 | en_US.UTF8 |            | libc            |
 template0               | cloudsqladmin     | UTF8     | en_US.UTF8 | en_US.UTF8 |            | libc            | =c/cloudsqladmin                       +
                         |                   |          |            |            |            |                 | cloudsqladmin=CTc/cloudsqladmin
 template1               | cloudsqlsuperuser | UTF8     | en_US.UTF8 | en_US.UTF8 |            | libc            | =c/cloudsqlsuperuser                   +
                         |                   |          |            |            |            |                 | cloudsqlsuperuser=CTc/cloudsqlsuperuser
(7 rows)


customer=> CREATE TABLE customer_details(id int PRIMARY KEY NOT NULL,
name VARCHAR(50) NOT NULL,
customer(> phone INTEGER NOT NULL,
customer(> email VARCHAR(50),
customer(> gender CHAR(15),
customer(> city CHAR(100) NOT NULL
customer(> );

--######### INSERT #####################
customer=> INSERT INTO customer_details(id,name,phone,email,gender,city) VALUES(101,'Alex',987632110,'alex123@gmail.com','Male','Mangalore');
INSERT 0 1
customer=> select *from customer_details;
 id  | name |   phone   |       email       |     gender      |                                                 city
-----+------+-----------+-------------------+-----------------+------------------------------------------------------------------------------------------------------
 101 | Alex | 987632110 | alex123@gmail.com | Male            | Mangalore
(1 row)

customer=> INSERT INTO customer_details(id,name,phone,email,gender,city) VALUES(102,'Barbara',927432110,'barabara34@gmail.com','Female','Bangalore');                                                                                   
INSERT 0 1
customer=> select *from customer_details;
 id  |  name   |   phone   |        email         |     gender      |                                                 city
-----+---------+-----------+----------------------+-----------------+------------------------------------------------------------------------------------------------------
 101 | Alex    | 987632110 | alex123@gmail.com    | Male            | Mangalore
 102 | Barbara | 927432110 | barabara34@gmail.com | Female          | Bangalore
(2 rows)


customer=> INSERT INTO customer_details(id,name,phone,email,gender,city) VALUES(103,'Joy',812432110,'joy134@gmail.com','Female','Udupi');                                                                                               
INSERT 0 1
customer=> INSERT INTO customer_details(id,name,phone,email,gender,city) VALUES(104,'Pranam',871090123,'pranam135@gmail.com','Male','Mumbai');                                                                                          
INSERT 0 1

--############## SELECT ####################
customer=> select *from customer_details;


id  |  name   |   phone   |        email         |     gender      |                                                 city
-----+---------+-----------+----------------------+-----------------+------------------------------------------------------------------------------------------------------
 101 | Alex    | 987632110 | alex123@gmail.com    | Male            | Mangalore
 102 | Barbara | 927432110 | barabara34@gmail.com | Female          | Bangalore
 103 | Joy     | 812432110 | joy134@gmail.com     | Female          | Udupi
 104 | Pranam  | 871090123 | pranam135@gmail.com  | Male            | Mumbai
(4 rows)

--############### UPDATE #######################

customer=> Update customer_details SET city='Pune' where id=104;
UPDATE 1
customer=> select *from customer_details;                                                                                                                                                                                               
 id  |  name   |   phone   |        email         |     gender      |                                                 city
-----+---------+-----------+----------------------+-----------------+------------------------------------------------------------------------------------------------------
 101 | Alex    | 987632110 | alex123@gmail.com    | Male            | Mangalore
 102 | Barbara | 927432110 | barabara34@gmail.com | Female          | Bangalore
 103 | Joy     | 812432110 | joy134@gmail.com     | Female          | Udupi
 104 | Pranam  | 871090123 | pranam135@gmail.com  | Male            | Pune
(4 rows)

--################ DELETE ##########################

customer=> DELETE from customer_details WHERE id='103';
DELETE 1
customer=> select *from customer_details;                                                                                                                                                                                               
 id  |  name   |   phone   |        email         |     gender      |                                                 city
-----+---------+-----------+----------------------+-----------------+------------------------------------------------------------------------------------------------------
 101 | Alex    | 987632110 | alex123@gmail.com    | Male            | Mangalore
 102 | Barbara | 927432110 | barabara34@gmail.com | Female          | Bangalore
 104 | Pranam  | 871090123 | pranam135@gmail.com  | Male            | Pune
(3 rows)


