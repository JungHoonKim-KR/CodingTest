import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int arr[] = new int [n];
        int countArr[] =new int[1000001];
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            countArr[num]++;
        }

        for(int i =0; i<n; i++){
            while(!stack.isEmpty() && countArr[arr[stack.peek()]] < countArr[arr[i]]){
                arr[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            arr[stack.pop()] = -1;
        }

        for(int i =0; i<n; i++){
            sb.append(arr[i]).append(" ");
        }

        System.out.print(sb);
    }
}