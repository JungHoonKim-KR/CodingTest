import java.util.*;
import java.io.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int index1=0;
        int index2=0;
        boolean check = true;
        for(String card : goal){
            if(index1 != cards1.length && cards1[index1].equals(card)){
                index1++;
            }
            else if(index2 != cards2.length && cards2[index2].equals(card)){
                index2++;
            }
            else{
                check = false;
                break;
            }
        }
        String answer = "Yes";
        
        if(!check) answer = "No";
        return answer;
    }
}