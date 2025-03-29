-- 코드를 입력하세요
SELECT ANIMAL_TYPE,
    CASE 
    when NAME IS null then 'No name'
    else NAME end as NAME
    ,
    SEX_UPON_INTAKE
from ANIMAL_INS