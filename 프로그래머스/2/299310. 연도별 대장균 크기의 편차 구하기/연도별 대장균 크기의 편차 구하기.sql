-- 코드를 작성해주세요
select  YEAR(DIFFERENTIATION_DATE) as YEAR,
        ed2.SIZE - ed1.SIZE_OF_COLONY as YEAR_DEV,
        ed1.id as ID
from ECOLI_DATA ed1
        join
    (select YEAR(DIFFERENTIATION_DATE) as YEAR, 
                MAX(SIZE_OF_COLONY) as SIZE
        from ECOLI_DATA
        group by YEAR(DIFFERENTIATION_DATE)
    ) ed2
    on YEAR(ed1.DIFFERENTIATION_DATE) =  ed2.YEAR
order by YEAR, YEAR_DEV;