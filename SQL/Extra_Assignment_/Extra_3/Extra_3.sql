
DROP DATABASE IF EXISTS Extra_assignment2;
CREATE DATABASE Extra_assignment2;
USE Extra_assignment2;

CREATE TABLE Trainee(
	TraineeID 			INT AUTO_INCREMENT PRIMARY KEY,
    Full_Name 			VARCHAR(50) NOT NULL,
    Birth_Date 			DATE NOT NULL,
    Gender 				ENUM("male", "female", "unknown") NOT NULL,
    ET_IQ 				TINYINT UNSIGNED NOT NULL ,
    ET_Gmath 			TINYINT UNSIGNED NOT NULL,
    ET_English 			TINYINT UNSIGNED NOT NULL,
    Training_Class 		VARCHAR(10) NOT NULL,
    Evaluation_Notes 	LONGTEXT
);

CREATE TABLE table1(
	ID 					MEDIUMINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    Name 				VARCHAR(50),
    Code 				CHAR(10),
    ModifiedDate 		DATETIME DEFAULT NOW()
);

CREATE TABLE table2(
	ID 					MEDIUMINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    Name 				VARCHAR(50),
    BirthDate 			DATE,
    Gender 				ENUM("male", "female", "unknown") ,
    IsDeletedFlag 		ENUM("0", "1")
);

ALTER TABLE Trainee ADD VTI_Account VARCHAR(25) NOT NULL UNIQUE;
