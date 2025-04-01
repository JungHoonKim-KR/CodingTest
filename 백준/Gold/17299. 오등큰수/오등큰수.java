import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int arr[] = new int [n];
        Map<Integer, Integer> countMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            countMap.put(num, countMap.getOrDefault(num, 0) +1);
        }

        for(int i =0; i<n; i++){
            while(!stack.isEmpty() && countMap.get(arr[stack.peek()]) < countMap.get(arr[i])){
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