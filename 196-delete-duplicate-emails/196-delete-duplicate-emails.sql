# Please write a DELETE statement and DO NOT write a SELECT statement.
# Write your MySQL query statement below


delete from Person where id in (
select ext_id from (select p1.id as ext_id from Person p1 inner join Person p2 on (p1.id > p2.id and p1.email = p2.email)) e);


# (select p1.id from Person p1 inner join Person p2 on (p1.id < p2.id and p1.email = p2.email));