Overview:
The Web Application Grocery Hub helps the Users to buy groceries on a daily, weekly, or as-needed
basis for Home Delivery or in-store pickup. The users can view the nearest five stores from their location
and select the respective store to buy their groceries. The Application supports trending Realtime features
of Latest, Top Sold and Top-Rated Products.

Requirements:
1) A Customer must be able to Create an Account, login and view all the products at nearby 5 different
stores.
2)The Customers can see the Stock of Items in the Store, they can write a Review for a Product and also
View the past Reviews of all the products.
3)The Customer must then be able to add a product to his cart and proceed to checkout page.
4)The Customer will enter his/her billing details like name, email, credit card number etc., in the checkout
page and finally place the order.
5) The Customer can see his/her Order History and is also shown a variety of Recommended Products
based on their Ratings.
6)The Customer is also shown different number of Matching Tweets and their respective products.
7)The Customer can also ask any Queries in the Contact Us section, and the Admin can view all the
queries and respond to them accordingly.
8)The Admin can create 5 Store Manager Accounts and also perform various actions like Add, Update,
Delete products from different Stores.
9)The Admin can also View the Following Analytics Related to the Products at Every Store:
	a)Stock of all Products at Every Store
	b)Sales by Product and totals sales in a day with their respective charts.
	c)Heat Maps for the following 5 features:
		1)Reviews at every store location.
		2)Transaction at every store location.
		3)Total Number of Disliked(Rating<3) products
		4)Total Number of Liked(Rating>=3) products
		5)Total Number of Store Pickups.
	d)Feedback of all Customers
	e)Reviews of all the Products
10)All the five Store Manager/s can view the following features:
	a)Order History of all the orders placed at his/her store.
	b)Add, Update & Delete Products from their respective store/s.
	c)Charts for the Stock of Products and Sales by the Respective product category.

Tools and Technologies Used:
Tools:
Sublime Text, Notepad++, MySQL Workbench, MongoDB Compass, Neo4j Desktop, Anaconda
Navigator, Jupyter Notebook.

Technologies:
Front End :
HTML, CSS, Bootstrap, Font Awesome, JavaScript, Ajax, JSP, jQuery,
jQuery Plugins - owl carousel, slicknav, nice-select, validation
Google Maps JavaScript API, Twitter API

Backend:
Java 14.0.2, Servlets

Server:
Apache Tomcat 9.0

Databases:
MySQL, Mongo DB, Neo4j

1)Total Lines Of Code ~ 8000

2)The Following features have been implemented:

2.1 User Account/Profile/Transaction management & MySQL - Implemented and Functional

2.2 Recommender - Implemented and Functional

2.3 Twitter matches - Implemented and Functional

2.4 Analytics & Visual Reports - Implemented and Functional                                  

2.5 Reviews & Trending & MongoDB - Implemented and Functional

2.6 Auto-Complete Search feature - Implemented and Functional

2.7 Google MAPS - Near ME search feature - Implemented and Functional

2.8 Knowledge Graph Searches & Neo4J - Implemented and Functional

Inorder to run the Project Grocery Hub, please follow the following steps:

*Install Apache Tomcat Server, Neo4j, MySQL and MongoDB and also download MYSQL Workbench, MongoDB Compass, Neo4j Desktop and Anaconda Navigator

*The default Port Numbers are as follows:
Tomcat-8080, Mysql-3306, MongoDB-27017, Neo4j-7474 please make sure no other application is using these port numbers.

*Download the following JAR files from "https://mvnrepository.com/" and place them in the CLASSPATH in the Environment Variables:
servlet-api.jar,jsp-api,el-api.jar,commons-beanutils-1.9.3.jar,mysql-connector-java-8.0.21.jar,mongo-java-driver-3.2.2.jar,gson-2.6.2.jar,java-json.jar,jstl-1.2.jar

*Place the Grocery Hub folder inside Tomcat Installation default directory as follows:
"C:\Program Files\Apache Software Foundation\Tomcat 9.0\webapps\Grocery Hub"

*Create a database named gorceryhub in MYSQL Workbench and run the Following Queries for the tables to be created.

1)registration:

CREATE TABLE `registration` (
  `Index` int NOT NULL AUTO_INCREMENT,
  `username` varchar(40) NOT NULL,
  `password` varchar(40) DEFAULT NULL,
  `usertype` varchar(40) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `address` varchar(150) DEFAULT NULL,
  `zipcode` bigint DEFAULT NULL,
  `storeid` int DEFAULT NULL,
  PRIMARY KEY (`Index`,`username`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


2)customerfeedback:

CREATE TABLE `customerfeedback` (
  `feedbackId` varchar(100) NOT NULL,
  `customerName` varchar(100) NOT NULL,
  `emailid` varchar(100) NOT NULL,
  `cproblem` varchar(10000) NOT NULL,
  PRIMARY KEY (`feedbackId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

3)customerorders:
CREATE TABLE `customerorders` (
  `OrderId` int NOT NULL,
  `username` varchar(150) NOT NULL,
  `emailid` varchar(150) NOT NULL,
  `firstname` varchar(150) NOT NULL,
  `lastname` varchar(150) NOT NULL,
  `customerAddress` varchar(150) NOT NULL,
  `customerZip` bigint NOT NULL,
  `customerPhoneNo` bigint NOT NULL,
  `orderNotes` varchar(150) NOT NULL,
  `creditCardNo` bigint NOT NULL,
  `productId` varchar(150) NOT NULL,
  `productName` varchar(150) NOT NULL,
  `pricePerItem` double NOT NULL,
  `no_of_items` int NOT NULL,
  `category` varchar(150) NOT NULL,
  `productSubTotal` double NOT NULL,
  `productWeight` varchar(150) NOT NULL,
  `orderTotal` double NOT NULL,
  `prodImg` varchar(45) NOT NULL,
  `StoreId` varchar(150) NOT NULL,
  `StoreAddress` varchar(150) NOT NULL,
  `StoreZip` bigint NOT NULL,
  `deliveryType` varchar(150) NOT NULL,
  `purchaseDate` date NOT NULL,
  `expectedDeliveryDate` date NOT NULL,
  PRIMARY KEY (`OrderId`,`username`,`productId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

4)product_details:
CREATE TABLE `product_details` (
  `Index` int NOT NULL AUTO_INCREMENT,
  `ProductId` varchar(50) NOT NULL,
  `ProductName` varchar(50) NOT NULL,
  `Image` varchar(50) NOT NULL,
  `Price` double NOT NULL,
  `Discount` double NOT NULL,
  `Category` varchar(50) NOT NULL,
  `Number_Of_Items` int NOT NULL,
  `Weight` varchar(50) NOT NULL,
  `s1` varchar(3) NOT NULL DEFAULT '',
  `s2` varchar(3) NOT NULL DEFAULT '',
  `s3` varchar(3) NOT NULL DEFAULT '',
  `s4` varchar(3) NOT NULL DEFAULT '',
  `s5` varchar(3) NOT NULL DEFAULT '',
  PRIMARY KEY (`Index`,`ProductId`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

5)storelist: 

CREATE TABLE `storelist` (
  `StoreID` int NOT NULL,
  `StoreName` varchar(45) DEFAULT NULL,
  `StoreAddress` varchar(45) DEFAULT NULL,
  `StoreZip` int DEFAULT NULL,
  `StoreLatLang` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`StoreID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


Import the respective csv files from the "DATA" folder inside Grocery Hub Zip to populate the tables. 

*Open Neo4j.txt inside the "DATA" folder and run the load CSV Cypher code followed by the Queries in the Neo4j Browser.

* Open jupyter notebook from the Anaconda Navigator and run the two python ipynb scripts inside "Python" folder in the Grocery Hub Zip
*The Twitter API Credentials have also been provided in the "PYTHON" folder with the name "credentials.txt" inside the "Python" folder in the Grocery Hub Zip
*The Google Maps Javascript API key is ""

*Open Command Prompt and go to the following directory
"C:\Program Files\Apache Software Foundation\Tomcat 9.0\webapps\Grocery Hub\WEB-INF\classes",
To compile all the java class files enter the command :javac *.java, 
before compiling please change the username and password from the the jdbc connection String in the Code.

*Open a web browser and type the URL: http://localhost:8080/Grocery%20Hub