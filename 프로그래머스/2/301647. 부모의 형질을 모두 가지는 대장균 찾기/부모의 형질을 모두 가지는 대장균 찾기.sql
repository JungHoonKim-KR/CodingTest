-- 코드를 작성해주세요
select c.ID, c.GENOTYPE, p.GENOTYPE as PARENT_GENOTYPE
from ECOLI_DATA c
join ECOLI_DATA p on c.parent_id = p.id
where (c.genotype & p.genotype) = p.genotype
order by id;