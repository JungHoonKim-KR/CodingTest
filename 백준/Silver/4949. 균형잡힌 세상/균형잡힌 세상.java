import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true){

            char[] charArr = br.readLine().toCharArray();
            if(charArr.length==1)
                break;
            if(isBalanced(charArr))sb.append("yes\n");
            else sb.append("no\n");

        }
        System.out.println(sb);
    }
    static boolean isBalanced(char charArr[]){
        Stack<Character>stack = new Stack();
        for(char c : charArr){
            if(c =='(' || c=='[')
                stack.push(c);
            else if(c==')'){
                if(stack.isEmpty() || stack.pop()!='(')
                    return false;
            }
            else if(c==']'){
                if(stack.isEmpty() || stack.pop()!='[')
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
