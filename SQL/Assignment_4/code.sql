-- Question 1: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ
USE Testing_system_assignment2;  

SELECT `Account`.Department_ID, `Account`.Full_Name,`Account`.Email,Department.Department_Name
FROM `Account`,Department
WHERE  `Account`.Department_ID =Department.Department_ID ;

SELECT `Account`.Department_ID, `Account`.Full_Name,`Account`.Email,Department.Department_Name
FROM `Account`
JOIN Department ON `Account`.Department_ID =Department.Department_ID;

-- Question 2: Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/12/2010
SELECT *
FROM `Account`
WHERE Creat_Date>"2010/12/20";

-- Question 3: Viết lệnh để lấy ra tất cả các developer
SELECT  `Account`.Full_Name, `Position`.Position_Name
FROM `Account`
JOIN  `Position` ON `Account`.Position_ID = `Position`.Position_ID
WHERE `Position`.Position_Name = 'DEV';

-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên
SELECT  Department.Department_Name, COUNT(`Account`.Department_ID) AS SỐ_LƯỢNG
FROM `Account`
JOIN  Department ON `Account`.Department_ID = Department.Department_ID
GROUP BY `Account`.Department_ID
HAVING COUNT(`Account`.Department_ID)>=3;

-- Question 5: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất
SELECT  Question.Content, COUNT(Question.Question_ID) AS SỐ_LƯỢNG
FROM Exam_Question
JOIN  Question ON Exam_Question.Question_ID = Question.Question_ID
GROUP BY Exam_Question.Question_ID 
HAVING 	COUNT(Exam_Question.Question_ID) = (SELECT MAX (COUNT(Exam_Question.Question_ID)) FROM Exam_Question.Question_ID );

-- Question 6: Thông kê mỗi category Question được sử dụng trong bao nhiêu Question
SELECT  Category_Question.Category_ID, Category_Question.Category_Name,COUNT(Category_Question.Category_ID) AS SỐ_LƯỢNG
FROM Question
JOIN  Category_Question ON Question.Category_ID = Category_Question.Category_ID
GROUP BY Question.Category_ID;

-- Question 7: Thông kê mỗi Question được sử dụng trong bao nhiêu Exam
SELECT Question.Question_ID, Question.Content ,COUNT(Question.Question_ID) AS SỐ_LƯỢNG
FROM Exam_Question
JOIN  Question ON Exam_Question.Question_ID = Question.Question_ID
GROUP BY Exam_Question.Question_ID;


