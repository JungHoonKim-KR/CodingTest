import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static int count=0;
    private static int cutLine;
    private static int result;
    private static void merge_sort(int [] arr, int left, int right){
        if(left < right){
            int mid = (left + right) /2;
            merge_sort(arr,left,mid);
            merge_sort(arr,mid+1,right);
            merge(arr,left,mid,right);

        }

    }
    private static void merge(int [] arr, int left, int mid, int right){
        int leftNum = mid - left +1;
        int rightNum = right  - mid;

        int [] L = new int[leftNum];
        int [] R = new int[rightNum];

        for(int i = 0;i<leftNum;i++) L[i] = arr[left+i];
        for(int i=0;i<rightNum;i++) R[i] = arr[mid+1+i];

        int i=0, j=0;
        int k = left;
        while(i<leftNum && j<rightNum){

            if(L[i]<R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            count++;

            if(count == cutLine){
                result = arr[k];
            }
            k++;
        }

        while(i<leftNum){
            arr[k] = L[i];
            i++;
            count++;
            if(count == cutLine){
                result = arr[k];
            }
            k++;
        }
        while(j<rightNum){
            arr[k] = R[j];
            j++;
            count++;
            if(count == cutLine){
                result = arr[k];
            }
            k++;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        cutLine = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int [] arr = new int[num];
        for (int i =0; i< num ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        merge_sort(arr,0,num-1);
        if(count<cutLine) bw.write(-1+"");
        else bw.write(result+"");
        bw.flush();
        bw.close();
    }
}