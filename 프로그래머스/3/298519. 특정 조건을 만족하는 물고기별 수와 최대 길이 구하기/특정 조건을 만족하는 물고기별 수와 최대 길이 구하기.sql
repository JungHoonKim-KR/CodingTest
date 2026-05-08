-- 코드를 작성해주세요
-- 평균 길이가 33cm 이상인 물고기들을 종류별로 분류
-- 10cm이하의 물고기들은 10cm로 취급하여 평균 길이를 구해주세요.

SELECT  COUNT(*) AS FISH_COUNT, MAX(LENGTH) AS MAX_LENGTH, FISH_TYPE
FROM FISH_INFO
GROUP BY FISH_TYPE
HAVING AVG(IFNULL(LENGTH, 10)) >= 33
ORDER BY FISH_TYPE;
