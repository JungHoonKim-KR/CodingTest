import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Stack<Integer>stack = new Stack();
        int num = 1;
        for(int i = 1; i<=n; i++){
            int target = Integer.parseInt(br.readLine());

            while(num<=n){
                if(!stack.isEmpty() && stack.peek() == target){
                    sb.append("-\n");
                    stack.pop();
                    break;
                }
                else {
                    sb.append("+\n");
                    stack.push(num++);
                }
            }
            if(num > n){
                if(stack.peek()== target){
                    sb.append("-\n");
                    stack.pop();
                }
                else{
                    System.out.println("NO");
                    System.exit(0);
                }
            }

        }
        System.out.println(sb);

    }

}
