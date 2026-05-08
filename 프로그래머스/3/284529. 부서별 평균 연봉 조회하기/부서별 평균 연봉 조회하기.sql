-- 코드를 작성해주세요
SELECT D.DEPT_ID, D.DEPT_NAME_EN, ROUND(AVG(SAL)) AS AVG_SAL
FROM HR_DEPARTMENT D
JOIN HR_EMPLOYEES  E
ON D.DEPT_ID = E.DEPT_ID

-- 부서별 평균 연봉을 조회하려 합니다
GROUP BY DEPT_ID
-- 평균연봉은 소수점 첫째 자리에서 반올림하고 컬럼명은 AVG_SAL로 해주세요
-- 결과는 부서별 평균 연봉을 기준으로 내림차순 정렬해주세요.
ORDER BY AVG_SAL DESC
