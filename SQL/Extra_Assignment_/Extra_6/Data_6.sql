USE Poject_Manager;
SELECT *FROM Projects;
INSERT INTO Projects(Manager_ID,Project_Name,Project_Start_Date,Project_Description,Project_Detail,Project_CompleteOn)	
VALUES				(1, "JAVA","2020/8/20","Làm nhanh lên", "Làm đúng hạn", "2020/11/11"),
					(2, "PYTHON","2019/3/15","Làm chậm thôi", "Làm đúng hạn", "2022/8/25"),
					(3, "C","2017/11/8","Làm nhanh lên","Làm quá hạn ","2021/6/17");
 

SELECT *FROM Employee;
INSERT INTO Employee(Employee_LastName,Employee_FistName,Employee_HireDate,Employee_Status,Supervisior_ID,Social_Security_Number)	
VALUES				("Hoang Van","Duong","2019/3/22","Làm Ok",3,6),
					("Le Dinh ","Vu","2018/1/15","Làm nhanh",2,5),		
					("Hoang Khanh","Linh","2019/7/21","Làm Ok",4,1);


SELECT *FROM Project_Modules;
INSERT INTO Project_Modules(Project_ID,Employee_ID,Project_Modules_Date,Project_Modules_Description,Project_ModulesCompleteOn)	
VALUES						(1,2,"2018/3/15","Làm Đúng hạn !", "2021/4/12"),
							(3,3,"2019/2/24","Làm QUá hạn !", "2022/3/12"),
                            (2,1,"2019/10/15","Làm Nhanh Quá !", "2020/5/12");


SELECT *FROM Work_Done;
INSERT INTO Work_Done(Employee_ID,Module_ID,WorkDone_Date,Employee_HireDate,WorkDone_Description,WorkDone_Status)	
VALUES				 (1,3,"2019/5/12","2019/3/1","Làm ok","1"),
					(3,1,"2018/4/12","2018/3/1","Chưa giao việc","0"),
                    (2,2,"2020/5/12","2020/3/1","Làm ok","1");
