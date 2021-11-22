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
SELECT  Q.Content, EQ.Question_ID,COUNT(Q.Content) AS SỐ_LƯỢNG
FROM Exam_Question Eq
JOIN Question Q ON Q.Question_ID =Eq.Question_ID
GROUP BY Eq.Question_ID
HAVING COUNT(Eq.Question_ID) = (SELECT MAX(SL) AS GTLN
									  FROM 
                                      (
                                      SELECT COUNT(Exam_Question.Question_ID) AS SL
                                      FROM Exam_Question
                                      GROUP BY  Exam_Question.Question_ID) AS MAX_count
                                      );
     									
-- Question 6: Thông kê mỗi category Question được sử dụng trong bao nhiêu Question
SELECT  Category_Question.Category_ID, Category_Question.Category_Name,COUNT(Category_Question.Category_ID) AS SỐ_LƯỢNG
FROM Question
JOIN  Category_Question ON Question.Category_ID = Category_Question.Category_ID
GROUP BY Question.Category_ID;

-- Question 7: Thông kê mỗi Question được sử dụng trong bao nhiêu Exam
SELECT  Eq.Question_ID,Q.Content,COUNT(Eq.Question_ID) AS SO_LUONG
FROM Exam_Question 	Eq
RIGHT JOIN  Question Q ON Eq.Question_ID = Q.Question_ID
GROUP BY Eq.Question_ID
ORDER BY SO_LUONG DESC;

-- Question 8: Lấy ra Question có nhiều câu trả lời nhất
SELECT A.Question_ID, Q.Content, COUNT(A.Question_ID) 
FROM Answer A
JOIN Question Q ON  A.Question_ID = Q.Question_ID
GROUP BY A.Question_ID
HAVING COUNT(A.Question_ID) = (SELECT MAX(COUNT(SO_LUONG)) AS TONG
								FROM (
                                SELECT COUNT(B.Question_ID) AS SO_LUONG
                                FROM Answer B
								GROUP BY B.Question_ID) AS GTLN
                                );


-- Question 9: Thống kê số lượng account trong mỗi group
SELECT  G.Group_ID, COUNT(GA.Group_ID) AS SỐ_LƯỢNG
FROM Group_Account GA
JOIN  `Group` G ON G.Group_ID = GA.Group_ID
GROUP BY GA.Group_ID;

-- Question 10: Tìm chức vụ có ít người nhất
SELECT A.Position_ID,A.Full_Name, P.Position_Name, COUNT(A.Position_ID)
FROM `Account` A
JOIN `Position` P ON A.Position_ID =P.Position_ID
GROUP BY A.Position_ID
HAVING COUNT(A.Position_ID) = (SELECT MIN(SL) AS GTNN
							FROM (
							SELECT COUNT(Position_ID) AS SL
							FROM `Account`
							GROUP BY `Account`.Position_ID) AS SO_LUONG
							);
                            
-- Question 11: Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM
SELECT D.Department_ID, D.Department_Name,P.Position_Name,COUNT(P.Position_Name)AS SL
FROM `Account` A
INNER JOIN Department D ON A.Department_ID = D.Department_ID
INNER JOIN `Position` P ON  A.Position_ID = P.Position_ID
GROUP BY D.Department_ID, P.Position_ID;

-- Question 12: Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của question, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì, ...
SELECT Q.Question_ID, Q.Content, AC.Full_Name, C.Category_Name,T.Type_Name, A.Content
FROM Question Q 
INNER JOIN Type_Question T ON Q.Type_ID = T.Type_ID
INNER JOIN Answer A ON  Q.Question_ID = A.Question_ID
INNER JOIN `Account`AC  ON Q.Creator_ID = AC.Account_ID
INNER JOIN Category_Question C ON  Q.Category_ID = C.Category_ID
GROUP BY Q.Question_ID;

-- Question 13: Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm
SELECT Q.Question_ID, T.Type_ID, T.Type_Name, COUNT(Q.Type_ID)
FROM Question Q 
INNER JOIN Type_Question T ON Q.Type_ID = T.Type_ID
GROUP BY Q.Type_ID;

-- Question 14:Lấy ra group không có account nào
SELECT *
FROM `Group`G	
INNER JOIN Group_Account GA ON GA.Group_ID = G.Group_ID
GROUP BY  GA.Account_ID 
HAVING GA.Account_ID IS NULL;

-- Question 15: Lấy ra group không có account nào
SELECT * 
FROM Group_Account GA 
RIGHT JOIN `Group` G ON GA.Group_ID = G.Group_ID
WHERE GA.Account_ID IS NULL;

-- Question 16: Lấy ra question không có answer nào
SELECT Q.Question_ID 
FROM Answer A
RIGHT JOIN Question Q on A.Question_ID = Q.Question_ID
WHERE A.Answer_ID IS NULL;

-- Exercise 2: Union
-- Question 17: 
a) Lấy các account thuộc nhóm thứ 1
b) Lấy các account thuộc nhóm thứ 2
c) Ghép 2 kết quả từ câu a) và câu b) sao cho không có record nào trùng nhau
Question 18:
a) Lấy các group có lớn hơn 5 thành viên
b) Lấy các group có nhỏ hơn 7 thành viên
c) Ghép 2 kết quả từ câu a) và câu b)
