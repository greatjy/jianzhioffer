# 查找重复的电子邮箱
select
    Email
from 
   Person
group by
   Emial
having coung(Email) > 1;
