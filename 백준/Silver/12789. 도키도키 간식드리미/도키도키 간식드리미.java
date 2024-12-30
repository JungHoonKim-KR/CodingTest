import java.io.*;
import java.util.ArrayList;
import java.util.Stack;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Stack<String> stack = new Stack<>();
        String[] s = br.readLine().split(" ");
        int target = 1;
        int index = 0;
        while (target<=n) {
            if (index == n && !stack.isEmpty() && !stack.peek().equals(target + "")) {
                break;
            } else if (!stack.isEmpty() && stack.peek().equals(target + "")) {
                stack.pop();
                target++;
            } else if (s[index].equals(target + "") && index < n) {
                index++;
                target++;
            } else {
                stack.push((s[index]));
                index++;
            }

        }
        if (index == n && stack.isEmpty()) bw.write("Nice\n");
        else bw.write("Sad\n");
        bw.flush();
    }


}


