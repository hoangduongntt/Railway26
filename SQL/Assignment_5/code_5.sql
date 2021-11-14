USE Testing_system_assignment2;  

-- Question 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale
CREATE VIEW List_of_department_sale AS
SELECT A.Full_Name,A.Email, A.Department_ID, D.Department_Name
FROM`Account` A
JOIN Department D ON A.Department_ID = D.Department_ID
WHERE D.Department_Name ="Sale";

SELECT *
FROM List_of_department_sale;


-- Question 2: Tạo view có chứa thông tin các account tham gia vào nhiều group nhất
CREATE VIEW INFORMATION AS
SELECT A.Full_Name,A.User_Name,A.Email,COUNT(G.Account_ID) AS SO_LUONG
FROM Group_Account G
JOIN `Account` A  ON G.Account_ID = A.Account_ID
GROUP BY G.Account_ID 
HAVING COUNT(G.Account_ID) = (SELECT MAX(SL) AS GTLN
									  FROM 
                                      (
                                      SELECT COUNT(g.Account_ID ) AS SL
                                      FROM Group_Account g
                                      GROUP BY  g.Account_ID ) AS MAX_count
                                      );
SELECT *
FROM INFORMATION;

-- Question 3: Tạo view có chứa câu hỏi có những content quá dài (content quá 20 từ được coi là quá dài) và xóa nó đi
CREATE VIEW Length_18 AS
SELECT Q.Content 
FROM Question Q
WHERE LENGTH(Q.Content ) >20;

SELECT *
FROM Length_18;

DELETE 
FROM Length_18;
SET SQL_UPDATES = 0;


-- Question 4: Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất
CREATE VIEW max_department AS
SELECT D.Department_Name,COUNT(A.Department_ID) AS SO_LUONG
FROM Department D 
JOIN `Account` A  ON D.Department_ID = A.Department_ID
GROUP BY A.Department_ID
HAVING COUNT(A.Department_ID) = (SELECT MAX(SL) AS GTLN
									  FROM 
                                      (
                                      SELECT COUNT(a.Department_ID ) AS SL
                                      FROM `Account` a
                                      GROUP BY  a.Department_ID ) AS MAX_count
                                      );
SELECT *
FROM max_department;             
                        
-- Question 5: Tạo view có chứa tất các các câu hỏi do user họ Nguyễn tạo
CREATE VIEW user_ho_nguyen AS
SELECT A.Full_Name, A.Email, A.User_Name 
FROM Question Q 
JOIN `Account` A  ON Q.Creator_ID = A.Account_ID
WHERE SUBSTRING_INDEX (A.Full_Name,' ',1) ="Nguyen";

SELECT *
FROM user_ho_nguyen;   