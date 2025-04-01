import java.io.*;
import java.util.*;

public class Main{
    static long arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

         arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(getArea(0, n-1));

    }

    static long getArea(int left, int right){
        if(left == right){
            return arr[left];
        }

        int mid = left + (right - left)/2;

        long leftArea = getArea(left, mid);
        long rightArea = getArea(mid + 1, right);
        return Math.max(getMidArea(left, right, mid), Math.max(leftArea, rightArea));
    }

    static long getMidArea(int left, int right, int mid){
        int toLeft = mid;
        int toRight = mid;
        long minHeight = arr[mid];
        long area =minHeight;
        while(left<toLeft && toRight<right){
            if(arr[toLeft-1] < arr[toRight+1]){
                minHeight = Math.min(minHeight, arr[++toRight]);
            }
            else minHeight = Math.min(minHeight, arr[--toLeft]);
            area = Math.max(area, minHeight * (toRight - toLeft +1));
        }

        while(left < toLeft){
            minHeight = Math.min(minHeight, arr[--toLeft]);
            area = Math.max(area, minHeight * (toRight - toLeft +1));
        }
        while (toRight<right){
            minHeight = Math.min(minHeight, arr[++toRight]);
            area = Math.max(area, minHeight * (toRight - toLeft+1));
        }

        return area;
    }

}