
USE Testing_system_assignment2;  

-- Question 2: lấy ra tất cả các phòng ban
SELECT * FROM Department;

-- Question 3: lấy ra id của phòng ban "Sale"
SELECT Department_ID
FROM Department 
WHERE Department_Name = "Sale";

-- Question 4: lấy ra thông tin account có full name dài nhất
SELECT * 
FROM   `Account`
WHERE length(Full_Name) = (SELECT MAX(length(Full_Name)) FROM `Account`);

SELECT *
FROM  `Account`
ORDER BY length(Full_Name) DESC
LIMIT 1;

-- Question 5: Lấy ra thông tin account có full name dài nhất và thuộc phòng ban có id= 3
SELECT * 
FROM   `Account`
WHERE length(Full_Name) = (SELECT MAX(length(Full_Name)) FROM `Account` )AND Department_ID =3;


-- Question 6: Lấy ra tên group đã tham gia trước ngày 20/12/2019
SELECT * 
FROM Group_Account
WHERE Join_Date < "2019/12/20";

-- Question 7 Lấy ra ID của question có >= 4 câu trả lời
SELECT Question_ID, COUNT(Question_ID) AS SL
FROM Answer
GROUP BY Question_ID
HAVING COUNT(Question_ID)>=4
ORDER BY SL ASC;

-- Question 8: Lấy ra các mã đề thi có thời gian thi >= 60 phút và được tạo trước ngày 20/12/2019
SELECT * 
FROM  Exam     
WHERE Duration >=60 AND Create_Date <= "2019/12/20";

-- Question 9: Lấy ra 5 group được tạo gần đây nhất
SELECT * 
FROM  `Group`
ORDER BY  Create_Date 
LIMIT 5; 

-- Question 10: Đếm số nhân viên thuộc department có id = 2
SELECT Department_ID,COUNT(Account_ID) AS SỐ_LƯỢNG
FROM  `Account`
WHERE Department_ID = 2;
 
 -- Question 11: Lấy ra nhân viên có tên bắt đầu bằng chữ "D" và kết thúc bằng chữ "o"
SELECT Full_Name
FROM  `Account`
WHERE (SUBSTRING_INDEX(Full_Name, ' ', -1)) LIKE 'N%c' ;

-- Question 12: Xóa tất cả các exam được tạo trước ngày 20/12/2019
DELETE
FROM Exam
WHERE Create_Date < '2019-12-20';

-- Question 13: Xóa tất cả các question có nội dung bắt đầu bằng từ "câu hỏi"
DELETE 
FROM Question
WHERE (SUBSTRING_INDEX(Content,' ',2)) = 'Câu hỏi';
SET SQL_SAFE_UPDATES = 0;


-- Question 14: Update thông tin của account có id = 5 thành tên "Nguyễn Bá Lộc" và email thành loc.nguyenba@vti.com.vn
UPDATE `Account`
SET Full_Name = "Nguyễn Bá Lộc" ,
	Email = "loc.nguyenba@vti.com.vn"
WHERE Account_ID =5;    

-- Question 15: update account có id = 5 sẽ thuộc group có id = 4

UPDATE Group_Account
SET Account_ID =5
WHERE Group_ID = 4 ;


