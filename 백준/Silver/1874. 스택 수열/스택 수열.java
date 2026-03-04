import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int num=1;
    static int n;
    static Stack<Integer>stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());

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

