
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
WHERE length(Full_Name) = (SELECT MAX(length(Full_Name)) FROM `Account` );

-- Question 5: Lấy ra thông tin account có full name dài nhất và thuộc phòng ban có id= 3
SELECT * 
FROM   `Account`
WHERE length(Full_Name) = (SELECT MAX(length(Full_Name)) FROM `Account` ) AND Department_ID =3 ;

-- Question 6: Lấy ra tên group đã tham gia trước ngày 20/12/2019
SELECT * 
FROM Group_Account
WHERE Join_Date < "2019/12/20";

-- Question 8: Lấy ra các mã đề thi có thời gian thi >= 60 phút và được tạo trước ngày 20/12/2019
SELECT * 
FROM  Exam     
WHERE Duration >=60 AND Create_Date <= "2019/12/20";

-- Question 9: Lấy ra 5 group được tạo gần đây nhất
SELECT * 
FROM  `Group`
ORDER BY  Create_Date 
LIMIT 5; 

