
USE EXAM;
SELECT * FROM CUSTOMER;
INSERT INTO CUSTOMER(Name,Phone,Email,Address,Note)
VALUES              ("Duobam","772-759-3964","ehendren0@merriamwebster.com","93 Vera Parkway","Environmental"),
					("Bitwolf","242-498-2691","sgodilington1@goo.ne.jp","362 Westport Circle","Recruiting Manager"),
					("Prodder","181-235-7200","sdellorto2@yale.edu","13388 Cherokee Drive","Pharmacist"),
					("Overhold","525-999-1423","lhundey3@tamu.edu","38227 Corben Crossing","Account Representative II"),
					("Domainer","737-497-3435","dbutcher4@msu.edu","00844 Graedel Place","Design Engineer");

SELECT * FROM CAR;
INSERT INTO CAR(Maker,Model,Year,Color,Note)
VALUES  		("HONDA","1990","2010","Khaki","KMHHT6KJ3FU720215"),
				("TOYOTA","1991","2002","Indigo","KMHHT6KJ3FU720215"),
				("HONDA","2005","2000","Mauv","KMHHT6KJ3FU720215"),
				("TOYOTA","1995","2003","Blue","KNAGN4AD4F5968233"),
				("NISSAN","2011","2011","Indigo","KMHHT6KJ3FU720215");
                
SELECT * FROM CAR_ORDER;
INSERT INTO CAR_ORDER(CustomerID,CarID,Amount,SalePrice,OrderDate,DeliveryDate,DeliveryAddress,Status,Note)
VALUES					(1,1,20,1000,"2020/6/19","2021/8/20","74 Stephen Center","1","actuating"),
						(2,2,20,2000,"2021/3/20","2021/8/20","22 Annamark Parkway","1","Programmable"),
						(3,3,17,3000,"2020/5/20","2021/11/20","07 Parkside Alley","1","even-keeled"),
						(4,4,14,4000,"2021/2/20","2021/8/20","0 Lotheville Crossing","1","service-desk"),
						(5,5,17,5000,"2020/5/20","2020/11/20","509 Thompson Street","2","dedicated");
        
                
