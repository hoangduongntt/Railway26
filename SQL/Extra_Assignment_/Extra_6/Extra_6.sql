DROP DATABASE IF EXISTS Poject_Manager;
CREATE DATABASE  Poject_Manager;
USE Poject_Manager;

DROP TABLE IF EXISTS Projects;
CREATE TABLE Projects(
Project_ID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
Manager_ID TINYINT UNSIGNED NOT NULL,
Project_Name VARCHAR (50) NOT NULL,
Project_Start_Date DATE ,
Project_Description VARCHAR (50),
Project_Detail VARCHAR (50), 
Project_CompleteOn DATE 
);
DROP TABLE IF EXISTS Employee;
CREATE TABLE Employee(
Employee_ID  TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
Employee_LastName   VARCHAR (50) NOT NULL,
Employee_FistName	 VARCHAR (50) NOT NULL,
Employee_HireDate 	DATE ,
Employee_Status		 VARCHAR (50),
Supervisior_ID		TINYINT UNSIGNED NOT NULL,
Social_Security_Number TINYINT UNSIGNED NOT NULL,
FOREIGN KEY (Supervisior_ID) REFERENCES Employee(Employee_ID) ON DELETE CASCADE
);
DROP TABLE IF EXISTS Project_Modules;
CREATE TABLE Project_Modules(
Module_ID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
Project_ID TINYINT UNSIGNED NOT NULL,
Employee_ID TINYINT UNSIGNED NOT NULL,
Project_Modules_Date DATE ,
Project_Modules_Description VARCHAR (50),
Project_ModulesCompleteOn DATE ,
FOREIGN KEY (Project_ID) REFERENCES Projects(Project_ID) ON DELETE CASCADE,
FOREIGN KEY (Employee_ID) REFERENCES Employee(Employee_ID) ON DELETE CASCADE
);

DROP TABLE IF EXISTS Work_Done;
CREATE TABLE Work_Done(
WorkDone_ID	TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
Employee_ID TINYINT UNSIGNED NOT NULL,
Module_ID	TINYINT UNSIGNED NOT NULL, 
WorkDone_Date DATE ,
Employee_HireDate DATE ,
WorkDone_Description  VARCHAR (50),
WorkDone_Status ENUM("1","0"), -- 1: Hoàn Thành, 0: Không hoàn thành
FOREIGN KEY (Module_ID) REFERENCES Project_Modules(Module_ID) ON DELETE CASCADE,
FOREIGN KEY (Employee_ID) REFERENCES Employee(Employee_ID) ON DELETE CASCADE
);


