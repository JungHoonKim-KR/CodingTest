import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Queue<String> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("push")) {
                stack.add(st.nextToken());
            } else if (command.equals("pop")) {
                if (stack.isEmpty()) {
                    bw.write("-1\n");
                } else bw.write(stack.poll() + "\n");
            }else if(command.equals("size")){
                bw.write(stack.size() + "\n");
            }else if(command.equals("empty")){
                if(stack.isEmpty()){bw.write("1\n");}
                else bw.write("0\n");
            }else if(command.equals("front")){
                if(stack.isEmpty()){bw.write("-1\n");}
                else bw.write(stack.peek()+"\n");
            }else if(command.equals("back")){
                if(stack.isEmpty()){bw.write("-1\n");}
                else bw.write(((LinkedList<String>)stack).getLast()+"\n");
            }
        }

        bw.flush();
    }


}


