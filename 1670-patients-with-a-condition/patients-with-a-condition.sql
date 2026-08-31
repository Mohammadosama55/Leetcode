-- -- # Write your MySQL query statement below
-- select * from patients where conditions like 'DIAB1%'
--     or conditions like '%DIAB1%'
-- ;


SELECT *
FROM Patients
WHERE conditions LIKE 'DIAB1%' 
   OR conditions LIKE '% DIAB1%';
