-- 코드를 입력하세요
-- 조회수가 가장 높은 중고거래 게시물에 대한 첨부파일 경로
-- 기본적인 파일경로는 /home/grep/src/ 이며, 게시글 ID를 기준으로 디렉토리가 구분되
-- /home/grep/src/{BOARDER_ID}/FILE_ID+FILENAME+FILE_EXT
SELECT CONCAT('/home/grep/src/', f.BOARD_ID, '/', FILE_ID, FILE_NAME, FILE_EXT)   AS FILE_PATH
FROM USED_GOODS_BOARD b
JOIN USED_GOODS_FILE f
ON b.BOARD_ID = f.BOARD_ID
WHERE b.BOARD_ID = (SELECT BOARD_ID FROM USED_GOODS_BOARD ORDER BY VIEWS DESC 
LIMIT 1)
ORDER BY FILE_ID DESC
