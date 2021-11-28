USE Extra_assignment2;

SELECT * FROM Extra_assignment2.Trainee;
INSERT INTO Trainee (Full_Name			,Birth_Date		,Gender		,ET_IQ	,ET_Gmath,ET_English,Training_Class,Evaluation_Notes,VTI_Account)
VALUES 				("Le Van Quy"		, "1993/1/28"	,"male"		,12		,11		 ,20		,"Class 1"	   , "KHA"			,1			),
					("Vu Thanh Huong"	, "1994/3/25"	,"female"	,9		,10		 ,19		,"Class 2"	   , "GIOI"			,2			),
					("Le Thanh Dat"		, "1997/6/8"	,"male"		,7		,5		 ,8			,"Class 2"	   , "TRUNG BINH"	,3			),
					("Hoang Van Duong"	, "1998/2/12"	,"male"		,7		,8		 ,9			,"Class 3"	   , "KHA"			,4			),
					("Hoang Khanh Linh"	, "1994/6/25"	,"female"	,6		,9		 ,10		,"Class 4"	   , "KHA"			,5			);
                    
SELECT * FROM Extra_assignment2.table1;
INSERT INTO table1 (Name				,Code		,ModifiedDate)
VALUES 			   ("GET IT"    		, "VTI 001"	,"2020/11/11"),  
				   ("COME BACK HOME"    , "VTI 002"	,"2021/03/20"), 
				   ("LETS GO !"    		, "VTI 003"	,"2020/09/13"), 
				   ("PUT THE HAND"    	, "VTI 004"	,"2020/08/1"), 
				   ("GET OUT!"    		, "VTI 005"	,"2019/06/15");
                    
SELECT * FROM Extra_assignment2.table2;
INSERT INTO table2 (Name				,BirthDate		,Gender		,IsDeletedFlag)
VALUES 			   ("Duong QUang Long"  , "1994/10/10"	,"male"		,	"0"		  ),  
				   ("Pham Van Truong"   , "1993/1/28"	,"male"		,	"1"		  ), 
				   ("Nguyen Van Ngoc"	, "1992/8/17"	,"female"	,	"1"		  ), 
				   ("Nguyen Dinh Anh"   ,  "1994/10/06"	,"male"		,   "0"	       ), 
				   ("Le Dinh Vu"    	, "1991/11/21"	,"female"	,   "1"	       );                    