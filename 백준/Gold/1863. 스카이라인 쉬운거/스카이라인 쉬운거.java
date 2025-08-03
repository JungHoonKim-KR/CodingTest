import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            while(!stack.isEmpty() && stack.peek()>y){
                stack.pop();
                result++;
            }
            if(!stack.isEmpty() && stack.peek() == y){
                continue;
            }

            stack.push(y);

        }


        while(!stack.isEmpty()){
           if(stack.peek() >0){
               result++;
           }
           stack.pop();
        }
        System.out.println(result);


    }




}
