import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < n; i++) {
            char[] charArray = br.readLine().toCharArray();
            for(char c : charArray) {
                stack.push(c);
            }
            int left = 0,right = 0;
            while(!stack.isEmpty()) {
                if(stack.pop() ==')')right++;
                else left++;
                if(left > right){
                    break;
                }
            }
            if(stack.isEmpty() && left == right)bw.write("YES\n");
            else bw.write("NO\n");
            stack.clear();

        }
        bw.flush();
    }
}



