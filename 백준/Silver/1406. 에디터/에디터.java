import java.io.*;
import java.util.Stack;

public class Main {
    static Stack<Character>stackL = new Stack<>();
    static Stack<Character>stackR = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] input = br.readLine().toCharArray();
        for(char c : input) {

            stackL.push(c);
        }

        int n = Integer.parseInt(br.readLine());

        while (n-->0){
            char[] cArr = br.readLine().toCharArray();
            command(cArr);
        }

        for(char c : stackL) {
            bw.write(c);
        }
        while (!stackR.isEmpty()) {
            bw.write(stackR.pop());
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static void command(char cArr[]){
        if(cArr[0] == 'L' && !stackL.isEmpty()){
            stackR.push(stackL.pop());
        }
        else if(cArr[0]=='D' && !stackR.isEmpty()){
            stackL.push(stackR.pop());
        }
        else if(cArr[0]=='B' && !stackL.isEmpty()){
            stackL.pop();
        }
        else if(cArr[0]=='P'){
            stackL.push(cArr[2]);
        }
    }
}

