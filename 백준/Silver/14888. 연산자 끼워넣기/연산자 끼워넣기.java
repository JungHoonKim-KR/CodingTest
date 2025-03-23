import java.io.*;
import java.util.*;


public class Main {
    static int numbers [];
    static int ops[];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ops = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        dfs(1,numbers[0]);

        System.out.println(max);
        System.out.println(min);

    }

    static void dfs(int depth, int value){
        if(depth == numbers.length){
            max = Math.max(max, value);
            min = Math.min(min, value);
            return;
        }

        for(int i =0; i<4; i++){
            if(ops[i]>0){
                ops[i] --;
                switch (i){
                    case 0:
                        dfs(depth+1, value + numbers[depth]);
                        break;
                    case 1:
                        dfs(depth+1, value - numbers[depth]);
                        break;
                    case 2:
                        dfs(depth+1, value * numbers[depth]);
                        break;
                    case 3:
                        dfs(depth+1, value / numbers[depth]);
                        break;
                }
                ops[i] ++;
            }

        }



    }






}
