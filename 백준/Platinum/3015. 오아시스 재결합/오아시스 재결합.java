import java.io.*;
import java.util.*;

public class Main {
    static class histogram{
        long height;
        int count;
        histogram(long height, int count){
            this.height = height;
            this.count = count;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        histogram[] histogram = new histogram[n];
        Stack<histogram>stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            histogram[i] = new histogram(Long.parseLong(br.readLine()), 1);
        }

        long count=0;
        for(int i =0; i<n; i++){
            while(!stack.isEmpty() && stack.peek().height<= histogram[i].height){
                histogram prev = stack.pop();
                if(prev.height == histogram[i].height){
                    histogram[i].count+=prev.count;
                }
                count += prev.count;
            }
            if(!stack.isEmpty()){
                count++;
            }
            stack.push(histogram[i]);
        }



        System.out.println(count);

    }


}