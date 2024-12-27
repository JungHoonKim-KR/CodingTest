import java.io.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int [n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int copied[] = arr.clone();
        Arrays.sort(copied);

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int num=0;
        for(int i =0; i<n; i++){
            if(i>=1 && copied[i-1] != copied[i]){
                num++;
            }
            hashMap.putIfAbsent(copied[i], num);
        }

        for(int i =0; i<n; i++){
            bw.write(hashMap.get(arr[i])+ " ");
        }
        bw.flush();
    }
}


