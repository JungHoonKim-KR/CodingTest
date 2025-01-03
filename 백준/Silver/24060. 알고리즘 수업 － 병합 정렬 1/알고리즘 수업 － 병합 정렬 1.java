import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    static int count=0;
    static int result =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int arr []=Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        merge_sort(arr, 0, arr.length-1, k);
        if(count<k) 
            result = -1;
            
        bw.write(result+"");
        bw.flush();;
        

    }

    static void merge_sort(int arr[], int left, int right, int k){
        if(left == right) return;
        int mid = (left + right) /2;
        merge_sort(arr, left, mid, k);
        merge_sort(arr, mid+1, right, k);
        merge(arr, left, mid, right, k);
    }

    static void merge(int arr[], int left, int mid, int right, int w){
        int i = left;
        int j = mid + 1;
        int temp[] = new int[right - left+1];
        int tempIdx = 0;
        while(i<=mid && j<=right){
            if(arr[i] <= arr[j]){
                temp[tempIdx++] = arr[i];
                count++;
                if(count ==w)
                    result = arr[i];
                i++;
            }
            else {
                temp[tempIdx++] = arr[j];
                count++;
                if(count ==w)
                    result = arr[j];
                j++;
            }
        }
        if(i>mid){
            while(j<=right){
                temp[tempIdx++] = arr[j];
                count++;
                if(count ==w)
                    result = arr[j];

                j++;
            }
        }
        if(j>right){
            while(i<=mid){
                temp[tempIdx++] = arr[i];
                count++;
                if(count ==w)
                    result = arr[i];
                i++;
            }
        }
        for(int k = left; k<=right; k++){
            arr[k] = temp[k - left];
        }
    }
}


