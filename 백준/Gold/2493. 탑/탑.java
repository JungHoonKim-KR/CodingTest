import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Stack<int[]>stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =1; i<=n; i++){
            int input = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty()){
                if(stack.peek()[1]>=input){
                    sb.append(stack.peek()[0]+" ");
                    break;
                }
                stack.pop();
            }

            if(stack.isEmpty()){
                sb.append("0 ");
            }
            stack.push(new int[]{i, input});

        }

        System.out.println(sb);

    }
}
