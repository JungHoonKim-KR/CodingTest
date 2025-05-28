import java.io.*;
import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        if(s.charAt(0) == ')' || s.charAt(s.length()-1) =='('){
            answer = false;
            return answer;
        }
        
        Stack<Character> stack = new Stack();
        
        for(int i =0; i<s.length(); i++){
            stack.add(s.charAt(i));
        }
        
        int left=0, right=0;
        
        
        while(!stack.isEmpty()){
            char pop = stack.pop();
            if(pop == '(')
                left++;
            else right++;
            
            if(right < left)
                break;
            
        }
        if(left != right)
            answer = false;
        return answer;
    }
}