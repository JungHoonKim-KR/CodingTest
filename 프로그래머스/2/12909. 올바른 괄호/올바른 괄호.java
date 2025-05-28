import java.io.*;
import java.util.*;
class Solution {
    boolean solution(String s) {
       int count = 0;
        for(int i =0; i<s.length(); i++){
            count += (s.charAt(i) == '(')? 1 : -1;
            if(count <0) return false;
        }
        return count==0;
    }
}