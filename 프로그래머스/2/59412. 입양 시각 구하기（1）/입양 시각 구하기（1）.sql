-- 코드를 입력하세요
SELECT HOUR(datetime) as HOUR
       ,count(*) as count
 from  animal_outs
 where HOUR(datetime) >= 9
 and   HOUR(datetime) < 20
 group by HOUR
 order by HOUR asc