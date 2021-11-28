USE Testing_system_assignment2;  

-- Question 1: Tạo trigger không cho phép người dùng nhập vào Group có ngày tạo trước 1 năm trước
DROP TRIGGER IF EXISTS  Gr_create_before_1year;
DELIMITER $$ 
CREATE TRIGGER Gr_create_before_1year
BEFORE
INSERT ON `Group` 
FOR EACH ROW
BEGIN
	IF new.Create_Date < DATE_SUB(now(), interval 1 YEAR) THEN
    SIGNAL SQLSTATE '12345'
    SET MESSAGE_TEXT = 'Fiel creat time must be less 1 year than now';
    END IF;
END $$
DELIMITER ; 
INSERT INTO `Group`		(Group_Name		,Creator_ID		,Create_Date)
VALUES  				("Test"			,   11			,"2021/11/11" );
    
-- Question 2: Tạo trigger Không cho phép người dùng thêm bất kỳ user nào vào department "Sale" nữa, khi thêm thì hiện ra thông báo "Department "Sale" cannot add more user"
DROP TRIGGER IF EXISTS  insert_to_department_sale;
DELIMITER $$ 
CREATE TRIGGER insert_to_department_sale
BEFORE
INSERT ON  `Account`
FOR EACH ROW
BEGIN
	DECLARE dep_id INT UNSIGNED;
    SELECT D.Department_ID INTO dep_id
    FROM Department D
    WHERE D.Department_Name = 'Sale';
    
	IF new.Department_ID = dep_id THEN
    SIGNAL SQLSTATE '12345'
    SET MESSAGE_TEXT = 'Department "Sale" cannot add more user';
    END IF;
END $$
DELIMITER ; 
INSERT INTO `Account`	(Email							,User_Name		,Full_Name					,Gender, Department_ID	,Position_ID	,Creat_Date)
VALUES                  ("nguyenthanhtung@gmail.com"	,"nttung"		,"Nguyen Thanh Tung"		,"M"		,4				,1			,"2019/11/02");

-- Question 3: Cấu hình 1 group có nhiều nhất là 5 user
DROP TRIGGER IF EXISTS  group_with_max_5user;
DELIMITER $$ 
CREATE TRIGGER group_with_max_5user
BEFORE
INSERT ON Group_Account
FOR EACH ROW
BEGIN
	DECLARE temp INT UNSIGNED;
    SELECT COUNT(GA.Group_ID) INTO temp
    FROM Group_Account GA
	WHERE GA.Group_ID = NEW.Group_ID;
    
	IF (temp>4) THEN
    SIGNAL SQLSTATE '12345'
    SET MESSAGE_TEXT = 'cant add more user this group ';
    END IF;
END $$
DELIMITER ; 
INSERT INTO 	Group_Account	(Group_ID	,Account_ID	,Join_Date)
VALUES                          (1			,7			,"2022/01/02");

-- Question 4: Cấu hình 1 bài thi có nhiều nhất là 3 Question

DROP TRIGGER IF EXISTS  exam_with_max_3question;
DELIMITER $$ 
CREATE TRIGGER exam_with_max_3question
BEFORE
INSERT ON Exam_Question
FOR EACH ROW
BEGIN
	DECLARE temp INT UNSIGNED;
    SELECT COUNT(EQ.Exam_ID) INTO temp
    FROM Exam_Question EQ
	WHERE EQ.Exam_ID = NEW.Exam_ID;
    
	IF (temp>3) THEN
    SIGNAL SQLSTATE '12345'
    SET MESSAGE_TEXT ='num question this exam is limit 3 ';
    END IF;
END $$
DELIMITER ; 
INSERT INTO Exam_Question (Exam_ID	,Question_ID)
VALUES                     (2		,8);

-- Question 5: Tạo trigger không cho phép người dùng xóa tài khoản có email là hoangvanduong@gmail.com (đây là tài khoản admin, không cho phép user xóa),
-- còn lại các tài khoản khác thì sẽ cho phép xóa và sẽ xóa tất cả các thông tin liên quan tới user đó

DROP TRIGGER IF EXISTS delete_account;
DELIMITER $$
CREATE TRIGGER delete_account
BEFORE
DELETE ON `Account`
FOR EACH ROW
BEGIN 
	DECLARE temp_email VARCHAR (50);
    SET temp_email = 'hoangvanduong@gmail.com';
    IF (old.Email = temp_email) THEN
    SIGNAL SQLSTATE '12345'
    SET MESSAGE_TEXT = 'YOU CANT DELETE THIS EMAIL';
    END IF;    
END $$
DELIMITER ;

DELETE 
FROM `Account` A
WHERE A.Email = 'lethanhdat@gmail.com';

-- Question 6: Không sử dụng cấu hình default cho field DepartmentID của table Account, hãy tạo trigger cho phép người dùng khi tạo account không điền
-- vào departmentID thì sẽ được phân vào phòng ban "waiting Department"

DROP TRIGGER IF EXISTS 	fill_in_departname;
DELIMITER $$
CREATE TRIGGER fill_in_departname
BEFORE
INSERT ON `Account`
FOR EACH ROW
BEGIN 
	DECLARE temp_departmentid VARCHAR (50);
	SELECT D.Department_ID INTO temp_departmentid
    FROM Department D
    WHERE  D.Department_Name ='waiting Department';
    
    IF (NEW.Department_ID IS NULL) THEN
	SET NEW.Department_ID = temp_departmentid;
    END IF;    
END $$
DELIMITER ;

INSERT INTO `Account`	(Email						,User_Name		,Full_Name			,Gender,Position_ID	,Creat_Date)
VALUES                  ("leminhhai@gmail.com"		,"lmhai"		,"Le Minh Hai"		,"M" ,1				,"2012/11/02");
    

-- Question 7: Cấu hình 1 bài thi chỉ cho phép user tạo tối đa 4 answers cho mỗi question, trong đó có tối đa 2 đáp án đúng.
DROP TRIGGER IF EXISTS max_answer;
DELIMITER $$
CREATE TRIGGER max_answer
BEFORE
INSERT ON Answer
FOR EACH ROW
BEGIN 
	DECLARE count_question_id TINYINT UNSIGNED;
    DECLARE count_iscorrect_id TINYINT UNSIGNED;
	
    SELECT COUNT(A.Question_ID) INTO count_question_id
    FROM Answer A
    WHERE A.Question_ID = NEW.Question_ID;
	SELECT COUNT(A.IsCorrect) INTO count_iscorrect_id
    FROM Answer A
    WHERE A.IsCorrect = NEW.IsCorrect;
    
    IF (count_question_id > 4 ) OR (count_iscorrect_id> 2) THEN
    SIGNAL SQLSTATE '12345'
    SET MESSAGE_TEXT = 'CANT INSERT MORE DATA';
    END IF;    
END $$
DELIMITER ;

INSERT INTO 		Answer	(	Content					,	Question_ID		,IsCorrect	)
VALUES                      (	"Câu tra loi so 11"		,	2				,7			);

-- Question 8: Viết trigger sửa lại dữ liệu cho đúng:
-- Nếu người dùng nhập vào gender của account là nam, nữ, chưa xác định
-- Thì sẽ đổi lại thành M, F, U cho giống với cấu hình ở database

DROP TRIGGER IF EXISTS insert_gender;
DELIMITER $$
CREATE TRIGGER insert_gender
BEFORE 
INSERT ON `Account`
FOR EACH ROW
BEGIN
	IF NEW.Gender = 'nam' THEN
    SET NEW.Gender = "M";
    ELSEIF NEW.Gender = 'nữ' THEN
    SET NEW.Gender = "F";
    ELSEIF NEW.Gender = 'chưa xác định giới tính' THEN
    SET NEW.Gender = "U";
    END IF ;
END $$
DELIMITER ;
INSERT INTO `Account`	(Email						,User_Name	,Full_Name			,Gender						, Department_ID	,Position_ID	,Creat_Date)
VALUES                  ("ledaican@gmail.com"		,"ldcan"	,"Le Dai Can"		, 'nam'						,8				,3				,"2020/11/02"),
						("hoangthanhminh@gmail.com"	,"htminh"	,"Hoang Thanh Minh"	, 'nữ'						,7				,2				,"2019/8/02"),
						("lethanhlong@gmail.com"	,"ltlong"	,"Le Thanh Long"	, 'chưa xác định giới tính'	,4				,1				,"2021/3/02");

-- Question 9: Viết trigger không cho phép người dùng xóa bài thi mới tạo được 2 ngày
DROP TRIGGER IF EXISTS delete_exam_before2day;
DELIMITER $$
CREATE TRIGGER delete_exam_before2day
BEFORE 
DELETE ON Exam
FOR EACH ROW
BEGIN
	IF (OLD.Create_Date > date_sub(now(), interval 2 day)) THEN
	SIGNAL SQLSTATE '12345'
    SET MESSAGE_TEXT = 'YOU CANT DELETE THIS EXAM';
    END IF;    
END $$
DELIMITER ;
DELETE
FROM Exam WHERE Exam_ID = 1;

-- Question 10: Viết trigger chỉ cho phép người dùng chỉ được update, delete các question khi question đó chưa nằm trong exam nào
DROP TRIGGER IF EXISTS ques_in_no_exam;
DELIMITER $$
CREATE TRIGGER ques_in_no_exam
BEFORE
UPDATE ON Question
FOR EACH ROW
BEGIN
	DECLARE temp_count TINYINT;
    SET temp_count =-1;
    SELECT COUNT(1) INTO temp_count
    FROM Exam_Question EQ
    JOIN Question Q ON EQ.Question_ID = Q.Question_ID
	WHERE EQ.Question_ID = NEW.Question_ID;
    
    IF (temp_count !=-1) THEN
	SIGNAL SQLSTATE '12345'
    SET MESSAGE_TEXT = 'YOU CANT UPDATE';
    END IF;    	
END $$
DELIMITER ;
UPDATE Question SET Content ="123" WHERE Question_ID=2;
-- Question 12: Lấy ra thông tin exam trong đó:
-- Duration <= 30 thì sẽ đổi thành giá trị "Short time"
-- 30 < Duration <= 60 thì sẽ đổi thành giá trị "Medium time"
-- Duration > 60 thì sẽ đổi thành giá trị "Long time"

SELECT E.Code_ID, E.Title, E.Duration, E.Create_Date, 
CASE
	WHEN E.Duration <=30 THEN "Short time"
    WHEN  E.Duration >30 AND E.Duration <60 THEN "Medium time"
    ELSE "Long time"
    END AS Time_duration
FROM Exam E;

-- Question 13: Thống kê số account trong mỗi group và in ra thêm 1 column nữa có tên là the_number_user_amount và mang giá trị được quy định như sau:
-- Nếu số lượng user trong group =< 5 thì sẽ có giá trị là few
-- Nếu số lượng user trong group <= 20 và > 5 thì sẽ có giá trị là normal
-- Nếu số lượng user trong group > 20 thì sẽ có giá trị là higher
SELECT GA.Group_ID, COUNT(GA.Group_ID),
CASE 
	WHEN COUNT(GA.Group_ID)<2 THEN "FEW"
    WHEN COUNT(GA.Group_ID)>=2 AND COUNT(GA.Group_ID)<4 THEN "NORMAL"
    ELSE "HIGHER"
    END AS the_number_user_amount
FROM Group_Account GA
GROUP BY GA.Group_ID;

-- Question 14: Thống kê số mỗi phòng ban có bao nhiêu user, nếu phòng ban nào không có user thì sẽ thay đổi giá trị 0 thành "Không có User"
SELECT D.Department_ID, COUNT(A.Department_ID),
CASE 
	WHEN COUNT(A.Department_ID) = 0 THEN "Không có User"
    ELSE COUNT(A.Department_ID)
    END AS SO_LUONG
FROM Department D
LEFT JOIN `Account` A ON D.Department_ID = A.Department_ID
GROUP BY D.Department_ID
