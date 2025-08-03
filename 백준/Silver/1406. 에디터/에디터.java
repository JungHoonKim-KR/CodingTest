import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] input  = br.readLine().toCharArray();
        int n = Integer.parseInt(br.readLine());
        Stack<Character> mainStack = new Stack<>();
        Stack<Character> tempStack = new Stack<>();

        for(char i : input) {
            mainStack.push(i);
        }

        // L : tempStack.push(mainStack.pop())
        // D : mainStack.push(tempStack.push())
        // B : mainStack.pop()
        // P $: mainStack.push()

        while(n -->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if(command.equals("L") && !mainStack.isEmpty()){
                tempStack.push(mainStack.pop());
            }
            else if(command.equals("D") && !tempStack.isEmpty()){
                mainStack.push(tempStack.pop());
            }
            else if(command.equals("B") && !mainStack.isEmpty()){
                mainStack.pop();
            }
            else if (command.equals("P")){
                mainStack.push(st.nextToken().charAt(0));
            }
        }

        while(!mainStack.isEmpty()){
            tempStack.push(mainStack.pop());
        }

        while (!tempStack.isEmpty()){
            sb.append(tempStack.pop());
        }
        System.out.println(sb);

    }
}
