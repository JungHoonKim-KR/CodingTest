import java.util.*;
import java.io.*;
class Solution {
    
    public int solution(int[][] targets) {
        
        Arrays.sort(targets, (t1, t2)->{
            if(t1[1]== t2[1]){
                return Integer.compare(t1[0], t2[0]);
            }
            return Integer.compare(t1[1], t2[1]);
        });
        
        int start =0;
        int end=0;
        int count=0;
        for(int[] t : targets){
            // 요격 범위 벗어남
            if(t[0] >=end){
                count++;
                start = t[0];
                end = t[1];
            }
        }
        
        int answer = count;
        return answer;
    }
}