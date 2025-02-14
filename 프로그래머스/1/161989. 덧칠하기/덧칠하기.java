import java.util.*;
class Solution {
    public int solution(int n, int m, int[] section) {
        int cur=0;
        int answer = 0;
        
        for(int sec : section){
            if(sec > cur){
                cur = sec + m -1;
                answer ++;
             
            }
        }
        
        
        
        return answer;
    }
}