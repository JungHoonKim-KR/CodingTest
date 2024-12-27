# [Silver V] 나이순 정렬 - 10814 

[문제 링크](https://www.acmicpc.net/problem/10814) 

### 성능 요약

메모리: 50064 KB, 시간: 540 ms

### 분류

정렬

### 제출 일자

2024년 12월 27일 15:31:17

### 문제 설명

<p>온라인 저지에 가입한 사람들의 나이와 이름이 가입한 순서대로 주어진다. 이때, 회원들을 나이가 증가하는 순으로, 나이가 같으면 먼저 가입한 사람이 앞에 오는 순서로 정렬하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 온라인 저지 회원의 수 N이 주어진다. (1 ≤ N ≤ 100,000)</p>

<p>둘째 줄부터 N개의 줄에는 각 회원의 나이와 이름이 공백으로 구분되어 주어진다. 나이는 1보다 크거나 같으며, 200보다 작거나 같은 정수이고, 이름은 알파벳 대소문자로 이루어져 있고, 길이가 100보다 작거나 같은 문자열이다. 입력은 가입한 순서로 주어진다.</p>

### 출력 

 <p>첫째 줄부터 총 N개의 줄에 걸쳐 온라인 저지 회원을 나이 순, 나이가 같으면 가입한 순으로 한 줄에 한 명씩 나이와 이름을 공백으로 구분해 출력한다.</p>

### 풀이
Map을 이용했고, 한 key에 여러 value가 가능해야 하기 때문에 Map<Integer, List<String>>을 이용했다.
조건에서 입력 순서를 지키라고 하지만 List라 신경쓰지 않아도 된다.

우선 값을 받아보자
```java
int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Map<Integer, List<String>> map = new HashMap<>();
        for(int i=0; i<n; i++){
            st  = new StringTokenizer(br.readLine());
            map.computeIfAbsent(Integer.parseInt(st.nextToken()),k->new ArrayList<>()).add(st.nextToken());
        }
```
value가 List 형태이기 때문에 최초에 초기화를 해줘야 해서 computeIfAbsent을 이용했다.
computeIfAbsent는 value인 ArrayList를 반환하기 때문에 add를 통해 값을 저장할 수 있다.

그 다음 중요한 개념은 Map이 Collection이 아니기 때문에 map 자체로는 정렬을 할 수가 없다는 것이다.
때문에 Map.entrySet()을 stream으로 변환해 정렬해야 했다.
```java
       HashMap<Integer, List<String>> collect = map.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, HashMap::new
                ));

```
이렇게 하면 21,[Junkyu, Dohyun]을 얻을 수 있다. 출력은 이중 for문으로 value를 순회했다.
```java
        for(Map.Entry<Integer,List<String>> entry : collect.entrySet()){
            for(String value:entry.getValue()){
                    bw.write(entry.getKey()+" "+ value+"\n");
            }
        }
```
map을 제대로 활용할 수 있었던 문제
String 2차원 배열로 하면 간단하지만 성능 차이가 많이 난다.
![image](https://github.com/user-attachments/assets/fc969b74-5414-4a78-94c6-8cdf9d25b771)


