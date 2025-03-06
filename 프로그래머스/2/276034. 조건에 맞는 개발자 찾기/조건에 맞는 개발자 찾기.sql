-- 코드를 작성해주세요
select Distinct ID, EMAIL, FIRST_NAME, LAST_NAME
from DEVELOPERS d
join SKILLCODES s on s.CODE & d.SKILL_CODE
where s.NAME = 'python' or s.NAME = 'c#'
order by ID
