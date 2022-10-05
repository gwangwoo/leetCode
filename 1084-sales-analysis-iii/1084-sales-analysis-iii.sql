# Write your MySQL query statement below


select p.product_id, p.product_name from product p
inner join 
(select distinct product_id from sales where product_id not in (select product_id from sales where sale_date < "2019-01-01" or sale_date > "2019-03-31")) as s
on p.product_id = s.product_id;