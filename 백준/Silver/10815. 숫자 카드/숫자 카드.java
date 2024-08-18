import java.io.*;
import java.lang.String;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.stream.IntStream;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int a_arr[] = new int[a];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int z = 0; z < a; z++) {
            a_arr[z] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a_arr);
        int b = Integer.parseInt(br.readLine());
        int b_arr[] = new int[b];
        st = new StringTokenizer(br.readLine());
        for (int k = 0; k < b; k++) {
            b_arr[k] = Integer.parseInt(st.nextToken());
        }
        int c[] = new int[b];
        StringBuilder sb=new StringBuilder();
        for(int j=0;j<b;j++){
            if(BInary(a_arr,a,b_arr[j])==1)
                c[j]=1;
            else c[j]=0;
            sb.append(c[j]+" ");

        }
        System.out.println(sb);




    }
    public static int BInary(int a[],int N,int t){
        int first=0;
        int last=N-1;
        int target=t;
        while(first<=last){
            int mid=(first+last)/2;
            if(target==a[mid])
                return 1;
            else if(target>a[mid])
                first=mid+1;
            else  last=mid-1;
            }
        return 0;
        }


    }














