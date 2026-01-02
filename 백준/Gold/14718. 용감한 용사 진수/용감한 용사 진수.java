import java.io.*;
import java.util.*;


class Stat{
    int s, d, i;
    Stat(int s, int d, int i){
        this.s = s;
        this.d = d;
        this.i = i;
    }
}

public class Main {
    static Stat[] arr;
    static int[] SArr;
    static int[] DArr;
    static int n, k;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new Stat[n];
        SArr = new int[n];
        DArr = new int[n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int Str = Integer.parseInt(st.nextToken());
            int Dex = Integer.parseInt(st.nextToken());
            int Int = Integer.parseInt(st.nextToken());
            arr[i] = new Stat(Str, Dex, Int);
            SArr[i] = Str;
            DArr[i] = Dex;
        }

        for(int s : SArr){
            for(int d : DArr){
                List<Integer> list = new ArrayList<>();
                for(Stat stat : arr){
                    if(stat.s <= s && stat.d <= d){
                        list.add(stat.i);
                    }
                }
                if(list.size() >= k){
                    Collections.sort(list);
                    result = Math.min(result, s+d+list.get(k-1));
                }
            }
        }

        System.out.println(result);

    }
}