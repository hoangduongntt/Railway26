USE EXAM;
-- 2. Viết lệnh lấy ra thông tin của khách hàng: tên, số lượng oto khách hàng đã mua và sắp sếp tăng dần theo số lượng oto đã mua.
SELECT CT.CustomerID, CT.NAME, O.Amount
FROM CAR_ORDER O
JOIN CUSTOMER CT ON O.CustomerID = CT.CustomerID
WHERE O.Status ="1"
GROUP BY O.Amount
HAVING O.Amount>0
ORDER BY O.Amount ASC;

-- 3. Viết hàm (không có parameter) trả về tên hãng sản xuất đã bán được nhiều oto nhất trong năm nay.
DROP VIEW IF EXISTS count_SL;
CREATE VIEW count_SL AS
SELECT C.Maker, SUM(O.Amount) AS SL
FROM CAR_ORDER O 
JOIN CAR C ON O.CarID = C.CarID
WHERE YEAR(O.DeliveryDate) = YEAR(NOW()) AND O.Status ="1"
GROUP BY C.Maker;

SET GLOBAL log_bin_trust_function_creators = 1;
DROP FUNCTION IF EXISTS get_maker;
DELIMITER $$
CREATE FUNCTION get_maker() 
RETURNS VARCHAR(50)
BEGIN
	DECLARE Dep_Name VARCHAR (50);
	SELECT Maker INTO Dep_Name FROM (SELECT Maker, Max(SL) FROM count_SL) AS SO_LUONG;
	RETURN Dep_Name;                    
END $$
DELIMITER ;
SELECT  get_maker();

-- 4. Viết 1 thủ tục (không có parameter) để xóa các đơn hàng đã bị hủy của những năm trước. In ra số lượng bản ghi đã bị xóa.
DROP PROCEDURE IF EXISTS delete_order;
DELIMITER $$
CREATE PROCEDURE  delete_order()
BEGIN
	SELECT *
    FROM CAR_ORDER 
    WHERE YEAR(DeliveryDate) < YEAR(now())  AND   Status = "2"; 
    
	DELETE
    FROM CAR_ORDER 
    WHERE YEAR(DeliveryDate) < YEAR(now())  AND   Status = "2"; 
	
END $$
DELIMITER ;

CALL delete_order();


-- 5. Viết 1 thủ tục (có CustomerID parameter) để in ra thông tin của các đơn hàng đã đặt hàng bao gồm: tên của khách hàng, mã đơn hàng, số lượng oto và tên hãng sản xuất.
DROP PROCEDURE IF EXISTS get_information;
DELIMITER $$
CREATE PROCEDURE  get_information(IN v_customer_ID TINYINT)
BEGIN
	SELECT O.CustomerID,CT.NAME, O.OrderID, O.Amount, C.Maker
    FROM CAR_ORDER  O
    JOIN CUSTOMER CT ON O.CustomerID = CT.CustomerID
    JOIN CAR C ON O.CarID = C.CarID
    WHERE O.CustomerID = v_customer_ID AND Status = "1"; 
END $$
DELIMITER ;
CALL get_information(4);


-- Viết trigger để tránh trường hợp người dụng nhập thông tin không hợp lệ vào database (DeliveryDate < OrderDate + 15).
DROP TRIGGER IF EXISTS  Insert_information;
DELIMITER $$ 
CREATE TRIGGER Insert_information
BEFORE 
INSERT ON CAR_ORDER
FOR EACH ROW
BEGIN
	IF NEW.DeliveryDate < DATE_SUB(NEW.OrderDate,  INTERVAL -15 DAY)  THEN
    SIGNAL SQLSTATE '12345'
    SET MESSAGE_TEXT = 'YOU CANT INSERT THIS TABLE';
    END IF;
END $$
DELIMITER ; 
INSERT INTO CAR_ORDER(CustomerID,CarID,Amount,SalePrice,OrderDate,DeliveryDate,DeliveryAddress,Status,Note)
VALUES					(4,4,20,1000,"2020/6/19","2021/6/20","74 Stephen Center","1","actuating");

