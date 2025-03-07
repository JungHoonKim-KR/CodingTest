-- 코드를 작성해주세요
select f.ITEM_ID, f.ITEM_NAME
from ITEM_INFO f
join ITEM_TREE t
on f.ITEM_ID = t.ITEM_ID
where t.PARENT_ITEM_ID is null
order by f.ITEM_ID