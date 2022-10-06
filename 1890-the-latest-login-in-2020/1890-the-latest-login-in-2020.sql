# Write your MySQL query statement below



select l.user_id, max(l.last_stamp) as last_stamp from (
    select user_id, time_stamp as last_stamp from Logins where YEAR(time_stamp) = '2020') 
as l
group by user_id 
