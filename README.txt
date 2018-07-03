This is a test application which uses the concepts from the links below :

https://dzone.com/articles/using-mysql-jdbc-driver-with-spring-boot

https://www.javatpoint.com/spring-boot-thymeleaf-view

It requires a mysql database named "test" , which has a table named "student" with the schema as follows : 

CREATE TABLE `student` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `AGE` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
)

This application does CRUD operations on this table via a web application.