-- Question
-- a) Tạo table với các ràng buộc và kiểu dữ liệu và thêm ít nhất 3 bản ghi vào mỗi table trên
-- b) Viết stored procedure (không có parameter) để Remove tất cả thông tin project đã hoàn thành sau 3 tháng kể từ ngày hiện. In số lượng record đã
-- remove từ các table liên quan trong khi removing (dùng lệnh print)
USE Poject_Manager;
DROP PROCEDURE IF EXISTS Remove_if_project;
DELIMITER $$
CREATE PROCEDURE Remove_if_project()
BEGIN
DELETE
FROM Projects 
WHERE DATEDIFF(Project_CompleteOn, Project_Start_Date) >90;
END $$
DELIMITER ;
Call Remove_if_project();

-- c) Viết stored procedure (có parameter) để in ra các module đang được thực hiện)

DROP PROCEDURE IF EXISTS Get_module;
DELIMITER $$
CREATE PROCEDURE Get_module(in v_moduele TINYINT UNSIGNED)
BEGIN
SELECT P.Module_ID, P.Project_ID,P.Project_Modules_Date,P.Project_Modules_Description,P.Project_ModulesCompleteOn
FROM Project_Modules P
WHERE P.Module_ID = v_moduele;
END $$
DELIMITER ;
Call Get_module(3);

-- d) Viết hàm (có parameter) trả về thông tin 1 nhân viên đã tham gia làm mặc dù không ai giao việc cho nhân viên đó (trong bảng Works)
DROP PROCEDURE IF EXISTS Get_Employee;
DELIMITER $$
CREATE PROCEDURE Get_Employee(in V_Work_Description VARCHAR(50))
BEGIN
SELECT E.Employee_ID,Concat(E.Employee_LastName," ", E.Employee_FistName) AS Full_Nanme, W.WorkDone_Description
FROM Work_Done W
JOIN Employee E ON W.Employee_ID = E.Employee_ID
WHERE W.WorkDone_Description = V_Work_Description;
END $$
DELIMITER ;
Call Get_Employee("Chưa giao việc");
