import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st =new StringTokenizer(br.readLine());
        int arr[] = new int[n];
        for(int i =0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }
        Stack<Integer> stack = new Stack<>();
        for(int i =0; i<n; i++){
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                arr[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            arr[stack.pop()] = -1;
        }

        for(int value : arr){
            sb.append(value+" ");
        }
        System.out.println(sb);

    }



}
