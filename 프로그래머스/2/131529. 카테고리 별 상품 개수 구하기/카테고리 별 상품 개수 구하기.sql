-- 코드를 입력하세요
SELECT subString(PRODUCT_CODE,1,2) as CATEGORY, count(PRODUCT_ID) as PRODUCTS
from PRODUCT
group by 1
order by 1