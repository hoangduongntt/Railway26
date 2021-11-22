USE Extra_assignment2;

-- Question 2: Viết lệnh để lấy ra tất cả các thực tập sinh đã vượt qua bài test đầu vào, nhóm chúng thành các tháng sinh khác nhau
CREATE OR REPLACE VIEW v_passed_fresher AS
SELECT *
FROM Trainee
WHERE ET_IQ >= 8
AND ET_Gmath >= 8
AND ET_English >= 15;

SELECT * FROM v_passed_fresher;

SELECT MONTH(Birth_Date), COUNT(Full_Name) FROM v_passed_fresher
GROUP BY MONTH(Birth_Date);

-- Question 3: Viết lệnh để lấy ra thực tập sinh có tên dài nhất, lấy ra các thông tin sau: tên, tuổi, các thông tin cơ bản (như đã được định nghĩa trong table)
SELECT *
FROM Trainee
GROUP BY Full_Name
HAVING LENGTH (Full_Name) = (SELECT MAX(length_name)
							FROM (
                            SELECT LENGTH (Full_Name) AS length_name
                            FROM Trainee
							GROUP BY Full_Name
                            ) AS dodai
                            );
-- Question 4: Viết lệnh để lấy ra tất cả các thực tập sinh là ET, 1 ET thực tập sinh là những người đã vượt qua bài test đầu vào và thỏa mãn số điểm như sau:
-- ET_IQ + ET_Gmath>=20
-- ET_IQ>=8
-- ET_Gmath>=8
-- ET_English>=18

SELECT *
FROM Trainee
WHERE (ET_IQ + ET_Gmath>=20) AND ET_IQ>=8 AND ET_Gmath>=8 AND ET_English>=18;

-- Question 5: xóa thực tập sinh có TraineeID = 3

DELETE
FROM Trainee
WHERE TraineeID = 3;

-- Question 6: Thực tập sinh có TraineeID = 5 được chuyển sang lớp "2". Hãy cập nhật thông tin vào database
UPDATE Trainee
SET  Training_Class = "Class 2"
WHERE TraineeID = 5;