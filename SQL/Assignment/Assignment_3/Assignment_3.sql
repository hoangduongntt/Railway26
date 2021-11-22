DROP DATABASE IF EXISTS Testing_system_assignment2;
CREATE DATABASE Testing_system_assignment2;
USE Testing_system_assignment2;

-- Tạo bảng Derpartment
DROP TABLE IF EXISTS Department;
CREATE TABLE Department(
	Department_ID 				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY UNIQUE ,
    Department_Name 			VARCHAR(50) NOT NULL UNIQUE KEY
);

-- Tạo bảng Position
DROP TABLE IF EXISTS `Position`;
CREATE TABLE`Position`(
	Position_ID 				TINYINT  UNSIGNED AUTO_INCREMENT PRIMARY KEY UNIQUE KEY,
    Position_Name 				VARCHAR(30) NOT NULL 
    
);

-- Tạo bảng Account
DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account`(
	Account_ID 					TINYINT  UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Email 						VARCHAR(50) NOT NULL UNIQUE KEY,
    User_Name 					VARCHAR(30) NOT NULL UNIQUE KEY,
    Full_Name 					VARCHAR(30) NOT NULL UNIQUE KEY,
    Department_ID 				TINYINT UNSIGNED NOT NULL,
    Position_ID 				TINYINT  UNSIGNED NOT NULL,
	Creat_Date 					DATE,
    FOREIGN KEY (Department_ID) REFERENCES Department(Department_ID),
    FOREIGN KEY (Position_ID) REFERENCES `Position`(Position_ID)
);

-- Tạo bảng Group
DROP TABLE IF EXISTS `Group`;
CREATE TABLE `Group`(
	Group_ID 					TINYINT  UNSIGNED AUTO_INCREMENT PRIMARY KEY  UNIQUE KEY,
    Group_Name 					VARCHAR(30) NOT NULL ,
    Creator_ID  				TINYINT NOT NULL UNIQUE KEY,
    Create_Date 				DATE
);

-- Tạo bảng Group_Account
DROP TABLE IF EXISTS Group_Account;
CREATE TABLE Group_Account(
	Group_ID 					TINYINT  UNSIGNED AUTO_INCREMENT   UNIQUE KEY,
    Account_ID 					TINYINT  UNSIGNED NOT NULL ,
	Join_Date 					DATE,
    PRIMARY KEY (Group_ID,Account_ID)
);

-- Tạo bảng Type_Question
DROP TABLE IF EXISTS Type_Question;
CREATE TABLE Type_Question(
	Type_ID 					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Type_Name 					ENUM ('Easay','Mutiple-Choice') NOT NULL
);

-- Tạo bảng Category_Question
DROP TABLE IF EXISTS Category_Question;
CREATE TABLE Category_Question(
	Category_ID 				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Category_Name 				VARCHAR(100) NOT NULL UNIQUE KEY
);

-- Tạo bảng Question
DROP TABLE IF EXISTS Question;
CREATE TABLE Question(
	Question_ID 				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content 					VARCHAR(200) NOT NULL,
    Category_ID         		TINYINT UNSIGNED NOT NULL,
    Type_ID             		TINYINT  UNSIGNED NOT NULL,
	Creator_ID 					TINYINT UNSIGNED NOT NULL UNIQUE KEY,
    Create_Date 				DATE,
	FOREIGN KEY (Category_ID) REFERENCES Category_Question(Category_ID),
	FOREIGN KEY (Type_ID) REFERENCES Type_Question(Type_ID)    
);

-- Tạo bảng Answer
DROP TABLE IF EXISTS Answer;
CREATE TABLE Answer(
	Answer_ID 					TINYINT AUTO_INCREMENT PRIMARY KEY,
    Content 					VARCHAR(200) NOT NULL,
    Question_ID 				TINYINT UNSIGNED NOT NULL,
	IsCorrect 					ENUM ('TRUE','FALSE') NOT NULL,
    FOREIGN KEY (Question_ID) REFERENCES Question(Question_ID)
);

-- Tạo bảng Exam
DROP TABLE IF EXISTS Exam;
CREATE TABLE Exam(
	Exam_ID 					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Code_ID 					TINYINT UNSIGNED NOT NULL UNIQUE KEY,
    Title 						VARCHAR(200) NOT NULL,
	Categoty_ID 				TINYINT UNSIGNED NOT NULL,
    Duration 					INT UNSIGNED NOT NULL ,
    Creator_ID 					TINYINT UNSIGNED NOT NULL UNIQUE KEY,
    Create_Date 				DATE	
);

-- Tạo bảng Exam_Question
DROP TABLE IF EXISTS Exam_Question;
CREATE TABLE Exam_Question(
	Exam_ID 					TINYINT UNSIGNED AUTO_INCREMENT  ,
    Question_ID 				TINYINT UNSIGNED NOT NULL,
	PRIMARY KEY (Exam_ID ,Question_ID)
    );


