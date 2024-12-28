import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int card[] = new int[n];
        StringTokenizer st  = new StringTokenizer(br.readLine());
        for(int i =0; i<n;i++){
            card[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(card);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<m;i++){
            int target = Integer.parseInt(st.nextToken());
            bw.write(binarySearch(target, card)+ " ");
        }


        bw.flush();
        bw.close();
    }

    static int binarySearch(int target, int arr[]){
        int first = 0;
        int last = arr.length-1;
        int mid = (first+last)/2;

        while(first <= last){
            if(arr[mid] == target){
                return 1;
            }else if(arr[mid]<target){
                first = mid+1;
                mid = (first+last)/2;
            }else if(arr[mid] > target){
                last = mid-1;
                mid = (first+last)/2;
            }else return 0;
        }

        return 0;
    }
}