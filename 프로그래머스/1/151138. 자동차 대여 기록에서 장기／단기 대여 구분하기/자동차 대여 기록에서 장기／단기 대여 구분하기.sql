-- 코드를 입력하세요
SELECT HISTORY_ID, CAR_ID, TO_CHAR(START_DATE, 'YYYY-MM-DD') as START_DATE,
                TO_CHAR(END_DATE,'YYYY-MM-DD') as END_DATE,
        case
        when END_DATE - START_DATE >=29
        then '장기 대여'
        else '단기 대여' 
        end as RENT_TYPE

  
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where START_DATE between TO_DATE('2022-09-01', 'YYYY-MM-DD')
                                                    and TO_DATE('2022-09-30', 'YYYY-MM-DD')

order by HISTORY_ID desc;