import java.io.*;
import java.util.ArrayList;
import java.util.Stack;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true){
            String s = br.readLine();
            if(s.equals("."))break;

            if(isBalanced(s.toCharArray())) bw.write("yes\n");
            else bw.write("no\n");

        }
        bw.flush();
    }

    static boolean isBalanced(char[] charArray){
        Stack<Character> stack = new Stack<>();
        for(char c : charArray) {
            if(c == '[' || c=='(')
                stack.push(c);
            else if(c ==')'){
                if(stack.isEmpty() || stack.pop() != '('){
                    return false;
                }
            }
            else if(c==']'){
                if(stack.isEmpty() || stack.pop() != '['){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}


