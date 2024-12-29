import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i =0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            if(num==0)arrayList.remove(arrayList.size()-1);
            else arrayList.add(num);
        }
        int result=0;
        for(Integer i : arrayList){
            result+=i;
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }
}



