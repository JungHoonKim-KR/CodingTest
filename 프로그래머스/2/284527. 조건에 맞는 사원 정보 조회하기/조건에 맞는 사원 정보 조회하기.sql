-- 코드를 작성해주세요
select SUM(g.score) as SCORE, g.EMP_NO, e.EMP_NAME, e.POSITION, e.EMAIL
from HR_EMPLOYEES  as e
join HR_GRADE as g
on g.EMP_NO = e.EMP_NO
group by g.EMP_NO
order by SCORE desc
limit 1