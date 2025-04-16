-- 코드를 작성해주세요
select parent.id as ID, COALESCE(count(child.parent_id),0) as CHILD_COUNT
from ECOLI_DATA as parent
left join ECOLI_DATA as child
on parent.id = child.parent_id
group by 1
order by 1

