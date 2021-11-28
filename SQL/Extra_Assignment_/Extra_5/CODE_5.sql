USE `adventureworks`;
 -- Exercise 1: Subquery
-- Question 1: Viết 1 query lấy thông tin "Name" từ bảng Production.Product có name
-- của ProductSubcategory là 'Saddles'.

			SELECT 	ProductSubcategoryID 
			FROM productsubcategory
			WHERE	Name = ('Saddles');

			SELECT 	Name 
			FROM 	product
			WHERE	ProductSubcategoryID = (SELECT 	ProductSubcategoryID 
											FROM productsubcategory
											WHERE	Name = ('Saddles'));
                                 
			             
	-- Question 2: Thay đổi câu Query 1 để lấy được kết quả sau.                                  

			SELECT 	Name 
			FROM 	product
			WHERE	ProductSubcategoryID IN (SELECT 	ProductSubcategoryID 
											 FROM 		productsubcategory
											 WHERE		Name LIKE 'Bo%');

-- Question 3:
-- Viết câu query trả về tất cả các sản phẩm có giá rẻ nhất (lowest ListPrice) và Touring Bike (nghĩa là ProductSubcategoryID = 3)

-- Exercise 2: JOIN nhiều bảng

-- Question 1: Viết query lấy danh sách tên country và province được lưu trong AdventureWorks2008sample database.
SELECT  C.Name, S.Name
FROM stateprovince S
JOIN countryregion C ON S.CountryRegionCode = C.CountryRegionCode
GROUP BY  S.Name;

-- Question 2: Lấy danh sách province của 2 nước Canada và Germany.
SELECT c.`Name` AS Country, s.`Name` AS Province
FROM countryregion c
JOIN stateprovince s
ON c.CountryRegionCode = s.CountryRegionCode
WHERE c.`Name` IN ('Canada', 'Germany');
-- Cách 2: Dùng UNION SELECT
SELECT c.`Name` AS Country, s.`Name` AS Province
FROM countryregion c
JOIN stateprovince s
ON c.CountryRegionCode = s.CountryRegionCode
WHERE c.`Name` = 'Canada'
UNION
SELECT c.`Name` AS Country, s.`Name` AS Province
FROM countryregion c
JOIN stateprovince s
ON c.CountryRegionCode = s.CountryRegionCode
WHERE c.`Name` = 'Germany';

-- Question 3: Lấy ra tất cả các đơn hàng offline, ngày tạo đơn, người bán, tiền thưởng.
-- Không tìm thấy field BusinessEntityID
SELECT 	soh.SalesOrderID, soh.OrderDate, 
		sp.SalesPersonID, sp.Bonus, sp.SalesYTD
FROM 	salesperson sp
JOIN	salesorderheader soh
ON		sp.SalesPersonID = soh.SalesPersonID
WHERE	soh.OnlineOrderFlag = 0;

-- Question 4: Lấy ra tất cả các đơn hàng offline, ngày tạo đơn, tên công việc, tiền thưởng.
-- Không tìm thấy field JobTitle
SELECT 	soh.SalesOrderID, soh.OrderDate, 
		sp.SalesPersonID, sp.Bonus, sp.SalesYTD
FROM 	salesperson sp
JOIN	salesorderheader soh
ON		sp.SalesPersonID = soh.SalesPersonID
WHERE	soh.OnlineOrderFlag = 0;