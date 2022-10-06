# Write your MySQL query statement below

select u.name, ifnull(r.dis, 0) as travelled_distance from users u left join (select user_id ,sum(distance) as dis from Rides group by user_id) as r on u.id = r.user_id order by r.dis desc, u.name asc;