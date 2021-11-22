-- Exercise 1:
-- Cho table sau:
-- Department (Department_Number, Department_Name)
-- Employee_Table (Employee_Number, Employee_Name,Department_Number)
-- Employee_Skill_Table (Employee_Number, Skill_Code, Date Registered)

-- Question 1: Tạo table với các ràng buộc và kiểu dữ liệu
DROP DATABASE IF EXISTS Extra_assignment4;
CREATE DATABASE Extra_assignment4;
USE Extra_assignment4;

DROP TABLE IF EXISTS Department;
CREATE TABLE Department (
Department_Number   TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
Department_Name		VARCHAR (50) NOT NULL
);

DROP TABLE IF EXISTS Employee_Table;
CREATE TABLE Employee_Table (
Employee_Number   TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
Employee_Name	  VARCHAR (50) NOT NULL,
Department_Number TINYINT UNSIGNED,
FOREIGN KEY (Department_Number) REFERENCES Department(Department_Number)
);

DROP TABLE IF EXISTS Employee_Skill_Table;
CREATE TABLE Employee_Skill_Table (
Employee_Number   TINYINT UNSIGNED,
Skill_Code		  VARCHAR (50) NOT NULL, 
Date_Registered   VARCHAR (50) NOT NULL,
FOREIGN KEY (Employee_Number) REFERENCES Employee_Table(Employee_Number)
);

-- Question 2: Thêm ít nhất 10 bản ghi vào table
INSERT INTO  Department    		(Department_Name)
VALUES							("Sale"),
								("Ky Thuat"),
								("Marketing"),
								("Nhân Sự"),
								("Hành Chinh"),
								("San Xuat"),
								("Ke Toan"),
								("Cham Soc Khach Hang"),
								("Tu Van Doi Ngoai");
                                
INSERT INTO Employee_Table 		(Employee_Name		,Department_Number)
VALUES							("Le Van Quy"		, 2				  ),
								("Nguyen Van Ngoc"	, 2				  ),
								("Nguyen Dinh Anh"	, 2				  ),
								("Hoang Khanh Linh"	, 3				  ),
								("Le Dinh Vu"		, 4				  ),
                                ("Pham Van Truong"	, 3				  ),
                                ("Duong Quang Long"	, 3				  ),
                                ("Vu Thanh Huong"	, 3				  );
                                
INSERT INTO Employee_Skill_Table 	(Employee_Number	,Skill_Code 	,Date_Registered)
VALUES								(2					, "JAVA"		,"2020/11/11"	),
									(3					, "C"			,"2020/6/1"		),
                                    (4					, "PYTHON"		,"2020/1/16"	),
                                    (3					, "C#"			,"2020/11/30"	),
                                    (5					, "LABVIEW"		,"2020/7/12"	),
									(6					,"JAVA"			,"2021/11/30"	);
								
-- Question 3: Viết lệnh để lấy ra danh sách nhân viên (name) có skill Java
-- Hướng dẫn: sử dụng UNION
SELECT B.Employee_Name, B.Department_Number, A.Employee_Number, A.Skill_Code
FROM Employee_Skill_Table A
JOIN Employee_Table B 
ON  A.Employee_Number = B.Employee_Number
WHERE A.Skill_Code = "JAVA";

-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >2 nhân viên

SELECT D.Department_Name, COUNT(E.Department_Number)
FROM Employee_Table E
JOIN Department D
ON E.Department_Number = D.Department_Number
GROUP BY E.Department_Number
HAVING COUNT(E.Department_Number)>2
ORDER BY COUNT(E.Department_Number) DESC ;

-- Question 5: Viết lệnh để lấy ra danh sách nhân viên của mỗi văn phòng ban. 
-- Hướng dẫn: sử dụng GROUP BY
SELECT D.Department_Number, D.Department_Name, E.Employee_Name
FROM Employee_Table E
JOIN Department D
ON E.Department_Number = D.Department_Number;

-- Question 6: Viết lệnh để lấy ra danh sách nhân viên có > 1 skills.
-- Hướng dẫn: sử dụng DISTINCT
SELECT DISTINCT  S.Employee_Number, E.Employee_Name, E.Department_Number,COUNT(S.Employee_Number) AS Skill
FROM Employee_Skill_Table S
JOIN  Employee_Table E ON S.Employee_Number = E.Employee_Number
GROUP BY S.Employee_Number
HAVING COUNT(S.Employee_Number)>1;
