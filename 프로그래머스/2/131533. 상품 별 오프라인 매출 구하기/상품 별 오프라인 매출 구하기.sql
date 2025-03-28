-- 코드를 입력하세요
SELECT P.PRODUCT_CODE, SUM(P.PRICE * O.SALES_AMOUNT) as SALES
from PRODUCT P
join OFFLINE_SALE O
on P.PRODUCT_ID = O.PRODUCT_ID
group by P.PRODUCT_CODE
order by SALES DESC, P.PRODUCT_CODE