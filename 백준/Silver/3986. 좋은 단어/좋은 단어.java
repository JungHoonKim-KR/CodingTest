import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        while(n-->0){
            char[] input = br.readLine().toCharArray();
            Stack<Character> stack = new Stack<>();

            for(int i = 0; i < input.length; i++){
                char c = input[i];

                if(stack.isEmpty()){
                    stack.push(c);
                }
                else if(stack.peek()==c){
                    stack.pop();
                }
                else{
                    stack.push(c);
                }
            }
            if(stack.isEmpty()){
                result++;
            }
        }
        System.out.println(result);
    }
}
