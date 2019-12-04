# Write your MySQL query statement below
select 
    w1.Id
from 
    Weather as w1 left join Weather as w2
on
    DATEDIFF(w1.RecordDate, w2.RecordDate) = 1
where w1.Temperature > w2.Temperature;
