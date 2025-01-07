# [Silver II] 가장 긴 증가하는 부분 수열 - 11053 

[문제 링크](https://www.acmicpc.net/problem/11053) 

### 성능 요약

메모리: 14508 KB, 시간: 124 ms

### 분류

다이나믹 프로그래밍

### 제출 일자

2025년 1월 7일 21:58:02

### 문제 설명

<p>수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.</p>

<p>예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {<strong>10</strong>, <strong>20</strong>, 10, <strong>30</strong>, 20, <strong>50</strong>} 이고, 길이는 4이다.</p>

### 입력 

 <p>첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)이 주어진다.</p>

<p>둘째 줄에는 수열 A를 이루고 있는 A<sub>i</sub>가 주어진다. (1 ≤ A<sub>i</sub> ≤ 1,000)</p>

### 출력 

 <p>첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.</p>

### 풀이
DP 말곤 생각이 안 난 문제. 
비슷하지만 약간은 다르게 두 방법으로 풀었다.
1. 정석적인 방법으로 arr[i]값을 기준으로 0부터 i까지의 거리를 구함
```java
       int max = 1;
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (arr[i] > arr[j]) {
                        dp[i] = Math.max(dp[j] + 1, dp[i]);
                        max = Math.max(max, dp[i]);
                    }
                }
        }
```
2. dp 인덱스를 값으로 하여 이하 동일하게 품
```java
       int max = 1;
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (arr[i] > arr[j]) {
                        dp[arr[i]] = Math.max(dp[arr[j]] + 1, dp[arr[i]]);
                        max = Math.max(max, dp[arr[i]]);
                    }
                }
        }
```
값을 이용해서 다르게 풀 수 있을 것 같았는데, 생각이 안나서 그냥 DP로 마무리 했다.
