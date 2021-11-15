-- Question 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các account thuộc phòng ban đó
USE Testing_system_assignment2; 
DROP PROCEDURE IF EXISTS print_account;
DELIMITER $$
CREATE PROCEDURE print_account(IN dpt_name VARCHAR(30))
BEGIN
	SELECT A.Full_Name, A.User_Name, A.Email, D.Department_ID, D.Department_Name
    FROM  `Account` A
    JOIN Department D ON A.Department_ID = D.Department_ID
    WHERE D.Department_Name = dpt_name;
END $$
DELIMITER ;

Call print_account("Sale");

-- Question 2: Tạo store để in ra số lượng account trong mỗi group
-- Cach 1
DROP PROCEDURE IF EXISTS print_count_account;
DELIMITER $$
CREATE PROCEDURE print_count_account(IN Gr_id INT)
BEGIN
	SELECT G.Group_ID, G.Group_Name, COUNT(GA.Account_ID) AS SL
    FROM  Group_Account GA
    JOIN `Group` G ON GA.Group_ID = G.Group_ID
	WHERE G.Group_ID = Gr_id;
END $$
DELIMITER ;
Call print_count_account(2);

-- Cach 2
DROP PROCEDURE IF EXISTS print_count_account;
DELIMITER $$
CREATE PROCEDURE print_count_account()
BEGIN
	SELECT G.Group_ID, G.Group_Name, COUNT(GA.Account_ID)
    FROM  Group_Account GA
    JOIN `Group` G ON GA.Group_ID = G.Group_ID
	GROUP BY G.Group_ID;
END $$
DELIMITER ;
Call print_count_account();

-- Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo trong tháng hiện tại
DROP PROCEDURE IF EXISTS print_count_type_question;
DELIMITER $$
CREATE PROCEDURE print_count_type_question()
BEGIN
	SELECT T.Type_Name, T.Type_ID ,Q.Content,Q.Create_Date, COUNT(Q.Type_ID)
    FROM  Question Q
    JOIN Type_Question T ON Q.Type_ID = T.Type_ID
	WHERE month(Q.Create_Date) = month(now()) AND year(Q.Create_Date) = year(now())
	GROUP BY Q.Create_Date;
END $$
DELIMITER ;
Call print_count_type_question();

-- Question 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất
Drop view if exists count_sl1;
CREATE VIEW count_sl1 AS
SELECT COUNT(E.Question_ID) AS SL
FROM Exam_Question E
GROUP BY  E.Question_ID;

DROP PROCEDURE IF EXISTS max_answer;
DELIMITER $$
CREATE PROCEDURE max_answer() 
BEGIN 
SELECT  Q.Content, EQ.Question_ID,COUNT(Q.Content) AS SỐ_LƯỢNG
FROM Exam_Question Eq
JOIN Question Q ON Q.Question_ID =Eq.Question_ID
GROUP BY Eq.Question_ID
HAVING COUNT(Eq.Question_ID) = (SELECT MAX(SL) FROM count_sl1);
END $$
DELIMITER ;
CALL max_answer(); 

-- Question 5: Sử dụng store ở question 4 để tìm ra tên của type question
Drop view if exists count_type1;
CREATE VIEW count_type1 AS
SELECT COUNT(Q.Type_ID) AS SL
FROM Question Q
GROUP BY  Q.Type_ID;

DROP PROCEDURE IF EXISTS max_answer;
DELIMITER $$
CREATE PROCEDURE max_answer() 
BEGIN 
SELECT  Q.Content, T.Type_ID,T.Type_Name,COUNT(T.Type_ID) AS SỐ_LƯỢNG
FROM Question Q
JOIN Type_Question T ON Q.Type_ID =T.Type_ID
GROUP BY Q.Type_ID
HAVING COUNT(Q.Type_ID) = (SELECT MAX(SL) FROM count_type1);
END $$
DELIMITER ;
CALL max_answer(); 

SET @ID=2;
SELECT * FROM Type_Question WHERE Type_ID=@ID;

-- Question 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên chứa chuỗi của người dùng nhập vào hoặc trả về user có username chứa chuỗi của người dùng nhập vào
DROP PROCEDURE IF EXISTS get_gr_or_use_name;
DELIMITER $$
CREATE PROCEDURE get_gr_or_use_name (IN var_String VARCHAR(50))
BEGIN
	SELECT G.Group_Name
    FROM `Group` G
    WHERE G.Group_Name LIKE CONCAT("%",var_String,"%")
    UNION 
    SELECT A.User_Name
    FROM `Account` A
    WHERE  A.User_Name LIKE CONCAT("%",var_String,"%");
END $$
DELIMITER ;
Call get_gr_or_use_name("HOANGVANDUONG");

-- Question 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và trong store sẽ tự động gán: 
-- username sẽ giống email nhưng bỏ phần @..mail đi
-- positionID: sẽ có default là developer
-- departmentID: sẽ được cho vào 1 phòng chờ
-- Sau đó in ra kết quả tạo thành công
SET GLOBAL log_bin_trust_function_creators = 1;

DROP PROCEDURE IF EXISTS insert_account;
DELIMITER $$
CREATE PROCEDURE insert_account (IN in_Fullname VARCHAR(50),IN in_Email VARCHAR(50))
BEGIN
	DECLARE in_username VARCHAR(50) DEFAULT SUBSTRING_INDEX(in_Email,"@", 1);
    DECLARE in_positionID TINYINT UNSIGNED DEFAULT 1;
    DECLARE in_departmentID TINYINT UNSIGNED DEFAULT 1;
    DECLARE in_Creat_Date DATE DEFAULT now();
    INSERT INTO `Account`	(Email			,User_Name		,Full_Name			,Department_ID		,Position_ID	,Creat_Date)
	VALUES                 	(in_Email		,in_username	,in_Fullname		,in_departmentID	,in_positionID	,in_Creat_Date);
END $$
DELIMITER ;
Call insert_account("Pham Thanh Dat", "phamthanhdat@gmail.com"); 

-- Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất

DROP PROCEDURE IF EXISTS get_length_content;
DELIMITER $$
CREATE PROCEDURE get_length_content (IN in_Type_Name VARCHAR (50))
BEGIN
	DECLARE in_Type_ID TINYINT UNSIGNED;
    SELECT T.Type_ID INTO in_Type_ID
    FROM Type_Question T
    WHERE T.Type_Name = in_Type_Name;
    IF in_Type_Name = "Easay" THEN
		WITH length_content AS (
			SELECT LENGTH(Q.Content) AS leng
            FROM Question Q
            WHERE Type_ID = in_Type_ID
        )
        SELECT *
        FROM Question Q
        WHERE Type_ID = in_Type_ID AND LENGTH(Q.Content) = (SELECT MAX(leng) FROM length_content);
	ELSE
		WITH length_content AS (
			SELECT LENGTH(Q.Content) AS leng
            FROM Question Q
            WHERE Type_ID = in_Type_ID
        )
        SELECT *
        FROM Question Q
        WHERE Type_ID = in_Type_ID AND LENGTH(Q.Content) = (SELECT MAX(leng) FROM length_content);
        END IF;
END $$
DELIMITER ;  
Call get_length_content("Mutiple-Choice");               
