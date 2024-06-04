import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());
        int command = 0, n = 0;
        StringTokenizer st;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            command = Integer.parseInt(st.nextToken());
            if (command == 1) {
                n = Integer.parseInt(st.nextToken());
                stack.push(n);
            } else if (command == 2) {
                if (stack.empty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(stack.peek()).append("\n");
                    stack.pop();
                }
            } else if (command == 3) {
                sb.append(stack.size()).append("\n");
            } else if (command == 4) {
                if (stack.empty())
                    sb.append(1).append("\n");
                else sb.append(0).append("\n");
            } else if (command == 5) {
                if (stack.empty())
                    sb.append(-1).append("\n");
                else sb.append(stack.peek()).append("\n");
            }


        }
        System.out.println(sb);
    }
}