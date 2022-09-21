# Write your MySQL query statement below
select t.class from (select *, count(*) cnt from Courses group by class) t where t.cnt >= 5;