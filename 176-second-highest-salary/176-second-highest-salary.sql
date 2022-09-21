# Write your MySQL query statement below
select IFNULL((select distinct salary from Employee order by salary desc limit 1 offset 1), null) as SecondHighestSalary;