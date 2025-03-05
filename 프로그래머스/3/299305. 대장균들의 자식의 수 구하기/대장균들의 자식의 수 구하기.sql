-- 코드를 작성해주세요
select ed.ID, 
(
    select count(*)
    from ECOLI_DATA
    where PARENT_ID = ed.ID
) as CHILD_COUNT
from ECOLI_DATA ed
