DROP DATABASE IF EXISTS Testing_system_assignment1;
CREATE DATABASE Testing_system_assignment1;
USE Testing_system_assignment1;
CREATE TABLE Department(
	Department_ID INT KEY AUTO_INCREMENT,
    Department_Name VARCHAR(50)
);
CREATE TABLE Position_Company(
	Position_ID INT KEY AUTO_INCREMENT,
    Position_Name VARCHAR(30)
    
);
CREATE TABLE Account_Company(
	Account_ID INT KEY AUTO_INCREMENT,
    Email VARCHAR(50),
    User_Name VARCHAR(30),
    Full_Name VARCHAR(30),
    Department_ID INT,
    Position_ID INT,
    Creat_Date DATE
);
CREATE TABLE Group_Company(
	Group_ID INT KEY AUTO_INCREMENT,
    Group_Name VARCHAR(30),
    Creator_ID  VARCHAR(30),
    Create_Date DATE
);
CREATE TABLE Group_Account(
	Group_ID	INT,
    Account_ID	INT,
    Join_Date DATE
);
CREATE TABLE Type_Question(
	Type_ID INT,
    Type_Name VARCHAR(200)
);
CREATE TABLE Category_Question(
	Category_ID INT,
    Category_Name VARCHAR(100)
);
CREATE TABLE Question(
	Question_ID INT KEY AUTO_INCREMENT,
    Content VARCHAR(200),
    Categoty_ID INT,
    Type_ID INT,
    Creator_ID INT,
    Create_Date DATE
);
CREATE TABLE Answer(
	Answer_ID INT KEY AUTO_INCREMENT,
    Content VARCHAR(200),
    Question_ID INT,
	IsCorrect ENUM ('TRUE','FALSE')
);

CREATE TABLE Exam(
	Exam_ID INT,
    Code INT,
    Title VARCHAR(200),
	Categoty_ID INT,
    Duration TIME,
    Creator_ID INT,
    Create_Date DATE
);
CREATE TABLE Exam_Question(
	Exam_ID INT,
    Question_ID INT
);


