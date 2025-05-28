import java.io.*;
import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        StringTokenizer st = new StringTokenizer(s);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while(st.hasMoreTokens()){
            int input = Integer.parseInt(st.nextToken());
            min = Math.min(min, input);
            max = Math.max(max, input);
        }
        answer = min + " "+max;
        return answer;
    }
}