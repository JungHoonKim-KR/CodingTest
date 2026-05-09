import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
       // k개 골라야함
        // 종류는 최소
        int answer = 0;
        Map<Integer, Integer> map = new HashMap();
        for(int i : tangerine){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        
        List<Integer> list = new ArrayList(map.keySet());
        
        Collections.sort(list,(a,b)->{
            return map.get(b)-map.get(a);
        });
        
        for(int i : list){
            k -= map.get(i);
            answer ++;
            if(k<=0) break;
        }
        
        return answer;
    }
}