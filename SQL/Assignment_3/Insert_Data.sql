
USE Testing_system_assignment2;  

-- Thêm dữ liệu vào bảng Department_Name
INSERT INTO Department     (Department_Name)
VALUES
							("Sale"),
							("Ky Thuat"),
							("Marketing"),
							("Nhân Sự"),
							("Hành Chinh"),
							("San Xuat"),
							("Ke Toan"),
							("Cham Soc Khach Hang"),
							("Tu Van Doi Ngoai");
                            
-- Thêm dữ liệu vào bảng Position                            
SELECT * FROM testing_system_assignment2.position;
INSERT INTO `Position`		(Position_Name)
VALUES                      ("Tong Giam Doc"),
							("Thu ky"),     
							("Bao ve"),
							("Pho Giam Doc"),  
							("Thu Ngan"),  
							("Ky su"),  
							("Le Tan"),  
							("Lao Cong"),  
							("Ke Toan"),  
							("Sale Marketing");   
                            
-- Thêm dữ liệu vào bảng Department_Name							
SELECT * FROM testing_system_assignment2.Account;
INSERT INTO `Account`	(Email						,User_Name		,Full_Name			,Department_ID	,Position_ID	,Creat_Date)
VALUES                  ("levanquy@gmail.com"		,"lvquy"		,"Le Van Quy"		,8				,1				,"2019/11/02"),
						("nguyenvanngoc@gmail.com"	,"nvngoc"		,"Nguyen Van Ngoc"	,3				,5				,"2018/11/04"),
						("ledinhanh@gmail.com"		,"ldanh"		,"Le Dinh Anh"		,4				,4				,"2012/1/25"),
						("hoangkhanhlinh@gmail.com"	,"hoangkl"		,"Hoang Khanh Linh"	,3				,3				,"2011/12/25"),
						("ledinhvu@gmail.com"		,"ldvu"			,"Le Dinh Vu"		,6				,2				,"1994/10/10"),
						("duongquanglong@gmail.com"	,"dglong"		,"Duong QUang Long"	,4				,6				,"1993/1/28"),
						("phamvantruogn@gmail.com"	,"pvtruong"		,"Pham Van Truong"	,3				,8				,"1992/8/17"),
						("vuthanhhuong@gmail.com"	,"vthuong"		,"Vu Thanh Huong"	,2				,4				,"1994/10/06"),
						("lethanhdat@gmail.com"		,"ltdat"		,"Le Thanh Dat"		,1				,9				,"1991/11/21"),
						("hoangvanduong@gmail.com"	,"hvd"			,"Hoang Van Duong"	,4				,10				,"1994/0/02");   
                        
 -- Thêm dữ liệu vào bảng Group                       
SELECT * FROM testing_system_assignment2.group;
INSERT INTO `Group`		(Group_Name		,Creator_ID		,Create_Date)
VALUES  				("Project1"		,4				,"2020/11/11" ),
						("Project2"		,5				,"2021/03/20"),
						("Project3"		,2				,"2022/09/13"),
						("Project4"		,1				,"2020/08/1"),
						("Project5"		,8				,"2018/09/21"),
						("Project6"		,9				,"2019/06/15"),
						("Project7"		,7				,"2022/02/12"),
						("Project8"		,3				,"2018/12/13"),
						("Project9"		,6				,"2017/09/25"),
						("Project10"	,10				,"2020/02/28");  

-- Thêm dữ liệu vào bảng Group_Account                        
SELECT * FROM testing_system_assignment2.Group_Account;
INSERT INTO 	Group_Account	(Group_ID	,Account_ID	,Join_Date)
VALUES                          (1			,1			,"2020/01/02"),
								(2			,2			,"2020/02/13"),
								(3			,3			,"2020/03/23"),
								(4			,4			,"2020/04/02"),
								(5			,5			,"2020/05/13"),
								(6			,6			,"2020/06/18"),
								(7			,7			,"2019/11/08"),
								(8			,8			,"2019/11/15"),
								(9			,9			,"2019/10/02"),
								(10			,10			,"2019/12/26");
 
 -- Thêm dữ liệu vào bảng Type_Question
SELECT * FROM testing_system_assignment2.type_question;
INSERT INTO 	Type_Question 	(Type_Name)
VALUE                           ("Easay"),
								("Mutiple-Choice");

-- Thêm dữ liệu vào bảng Category_Question                                
SELECT * FROM testing_system_assignment2.category_question;
INSERT INTO 		Category_Question	(Category_Name)
VALUES                                  ("jAVA"),
										("C"),
										("WEB"),
										("C++"),
										("MY SQL"),
										("PYTHON"),
										("MOBIPHONE"),
										("PASSCAL"),
										("C#"),
										("LABVIEW");
  
-- Thêm dữ liệu vào bảng Exam  
SELECT * FROM testing_system_assignment2.Exam;                                       
INSERT INTO 		Exam	(Code_ID	,Title				,Categoty_ID	,Duration	,Creator_ID	,Create_Date)
VALUES                      (1			,"Lap Trinh JAVA"	,1				,50			,1			,"2020/01/02"),
							(2			,"Lap Trinh C"		,2				,80			,2			,"2020/02/13"),
							(3			,"Lap Trinh C++"	,3				,70			,3			,"2020/03/23"),
							(4			,"Lap Trinh PYTHON"	,4				,60			,4			,"2020/04/02"),
							(5			,"Lap Trinh MOBILE"	,5				,50			,5			,"2020/05/13"),
							(6			,"Lap Trinh LABVIEW",6				,100		,6			,"2020/06/18"),
							(7			,"Lap Trinh PASSCAL",7				,40			,7			,"2019/11/08"),
							(8			,"Lap Trinh WEB	"	,8				,80			,8			,"2019/1/15"),
							(9			,"Lap Trinh MY SQL"	,9				,65			,9			,"2019/10/02"),
							(10			,"Lap Trinh C#"		,10				,70			,10			,"2019/12/26");                                        

-- Thêm dữ liệu vào bảng Exam_Question
SELECT * FROM testing_system_assignment2.exam_question;
INSERT INTO Exam_Question (Exam_ID	,Question_ID)
VALUE                     (1		,1),
						  (2		,2),
						  (3		,3),
						  (4		,4),
						  (5		,5),
						  (6		,6),
						  (7		,7),
						  (8		,8),
						  (9		,9),
						  (10		,10);									
   
  --  
																					