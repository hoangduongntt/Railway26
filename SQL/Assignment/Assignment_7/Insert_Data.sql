	USE Testing_system_assignment2;  

	-- Thêm dữ liệu vào bảng Department_Name
	SELECT * FROM testing_system_assignment2.Department;
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
	VALUES                  
								("DEV"),     
								("TEST"),  
								("SCRUM MASTER"),  
								("PM"); 
								
	-- Thêm dữ liệu vào bảng Department_Name							
	SELECT * FROM testing_system_assignment2.Account;
	INSERT INTO `Account`	(Email						,User_Name		,Full_Name			,Gender			, Department_ID	,Position_ID	,Creat_Date)
	VALUES                  ("levanquy@gmail.com"		,"lvquy"		,"Le Van Quy"		, 'M'			,8				,1				,"2019/11/02"),
							("nguyenvanngoc@gmail.com"	,"nvngoc"		,"Nguyen Van Ngoc"	, 'F'			,3				,1				,"2018/11/04"),
							("ledinhanh@gmail.com"		,"ldanh"		,"Nguyen Dinh Anh"	, 'M'			,4				,4				,"2012/1/25"),
							("hoangkhanhlinh@gmail.com"	,"hoangkl"		,"Hoang Khanh Linh"	, 'M'			,3				,4				,"2011/12/25"),
							("ledinhvu@gmail.com"		,"ldvu"			,"Le Dinh Vu"		, 'F'			,6				,2				,"1994/10/10"),
							("duongquanglong@gmail.com"	,"dglong"		,"Duong QUang Long"	, 'M'			,1				,3				,"1993/1/28"),
							("phamvantruogn@gmail.com"	,"pvtruong"		,"Pham Van Truong"	, 'F'			,3				,3				,"1992/8/17"),
							("vuthanhhuong@gmail.com"	,"vthuong"		,"Vu Thanh Huong"	, 'M'			,2				,4				,"1994/10/06"),
							("lethanhdat@gmail.com"		,"ltdat"		,"Le Thanh Dat"		, 'F'			,1				,3				,"1991/11/21"),
							("hoangvanduong@gmail.com"	,"hvd"			,"Hoang Van Duong"	, 'M'			,4				,4				,"1994/0/02");   
							
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
									(3			,1			,"2020/03/23"),
									(1			,4			,"2020/04/02"),
									(5			,2			,NULL),
									(1			,2			,"2020/06/18"),
									(2			,7			,"2019/11/08"),
									(1			,5			,"2019/11/15"),
									(1			,9			,"2019/10/02"),
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
	  
	SELECT * FROM testing_system_assignment2.Question;                                       
	INSERT INTO 		Question	(Content						,Category_ID	,Type_ID	,Creator_ID	,Create_Date)
	VALUES                      	("Câu hỏi về Lap Trinh JAVA"	,2				,1			,1			,"2020/01/02"),
									("Câu hỏi về Lap Trinh C"		,2				,1			,2			,"2021/11/02"),
									("Câu hỏi về Lap Trinh C++"		,3				,2			,3			,"2020/01/02"),
									(" Lap Trinh PYTHON"			,3				,1			,4			,"2021/11/05"),
									(" Trinh MOBILE"				,5				,2			,5			,"2020/03/02"),
									("Câu hỏi về Lap Trinh LABVIEW"	,1				,2			,6			,"2021/11/11"),
									("Câu hỏi về Lap Trinh PASSCAL"	,1				,1			,7			,"2021/04/02"),
									("Câu hỏi về Lap Trinh WEB"		,8				,2			,8			,"2020/06/02"),
									(" Trinh MY SQL"				,9				,1			,9			,"2020/07/02");

	-- Thêm dữ liệu vào bảng Answer  
	SELECT * FROM testing_system_assignment2.Answer;                                      
	INSERT INTO 		Answer	(	Content					,	Question_ID		,IsCorrect	)
	VALUES                      (	"Câu tra loi so 1"		,	2				,1			),
								(	"Câu tra loi so 2"		,	2				,3			),
								(	"Câu tra loi so 3"		,	4				,1			),
								(	"Câu tra loi so 4"		,	3				,4			),
								(	"Câu tra loi so 5"		,	6				,2			),
								(	"Câu tra loi so 6"		,	5				,3			),
								(	"Câu tra loi so 7"		,	2				,5			),
								(	"Câu tra loi so 8"		,	2				,6			),
								(	"Câu tra loi so 9"		,	4				,8			),
								(	"Câu tra loi so 10"		,	3				,7			);

	-- Thêm dữ liệu vào bảng Exam  
	SELECT * FROM testing_system_assignment2.Exam;                                       
	INSERT INTO 		Exam	(Code_ID	,Title				,Categoty_ID	,Duration	,Creator_ID	,Create_Date)
	VALUES                      (1			,"Lap Trinh JAVA"	,1				,50			,1			,"2020/01/02"),
								(2			,"Lap Trinh C"		,2				,80			,2			,"2020/02/13"),
								(3			,"Lap Trinh C++"	,3				,70			,3			,"2021/11/20"),
								(4			,"Lap Trinh PYTHON"	,4				,60			,4			,"2020/04/02"),
								(5			,"Lap Trinh MOBILE"	,5				,25			,5			,"2017/05/13"),
								(6			,"Lap Trinh LABVIEW",6				,100		,6			,"2020/06/18"),
								(7			,"Lap Trinh PASSCAL",7				,40			,7			,"2018/11/08"),
								(8			,"Lap Trinh WEB	"	,8				,80			,8			,"2016/1/15"),
								(9			,"Lap Trinh MY SQL"	,9				,65			,9			,"2019/10/02"),
								(10			,"Lap Trinh C#"		,10				,70			,10			,"2019/12/26");                                        

	-- Thêm dữ liệu vào bảng Exam_Question
	SELECT * FROM testing_system_assignment2.exam_question;
	INSERT INTO Exam_Question (Exam_ID	,Question_ID)
	VALUE                     (1		,2),
							  (2		,2),
							  (3		,3),
							  (4		,4),
							  (2		,3),
							  (6		,6),
							  (2		,5),
							  (8		,2),
							  (9		,9),
							  (10		,7);						