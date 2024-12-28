import java.io.*;
import java.lang.String;
import java.util.*;
import java.util.stream.IntStream;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int count=0;
        //문제 수 받기
        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());
        HashSet<Integer>hash1=new HashSet<Integer>();
        HashSet<Integer>hash2=new HashSet<Integer>();
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<a;i++){
           hash1.add(Integer.parseInt(st.nextToken()));

        }
        st=new StringTokenizer(br.readLine());
        for(int k=0;k<b;k++){
            int l=Integer.parseInt(st.nextToken());
            hash2.add(l);
            if(!hash1.contains(l))
                count++;

        }
        for(Integer temp:hash1){
            if(!hash2.contains(temp))
                count++;
        }
        System.out.println(count);







    }


}






















