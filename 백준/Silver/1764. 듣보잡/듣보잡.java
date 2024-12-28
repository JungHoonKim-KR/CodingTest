import java.io.*;
import java.lang.String;
import java.util.*;
import java.util.stream.IntStream;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        //문제 수 받기
        int a = Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());
        String a_arr[]=new String [a];
        HashSet<String>hash=new HashSet<String>();
        for(int i=0;i<a;i++){
           hash.add(br.readLine());
        }
    // 비교할 수 받
        String b_arr[]=new String[b];

        for(int j=0;j<b;j++){
            b_arr[j]=br.readLine();
        }
        Arrays.sort(b_arr);
        //비교
        StringBuilder sb=new StringBuilder();
        int count=0;
        for(int k=0;k<b;k++){
            if(hash.contains(b_arr[k])) {
                count++;
                sb.append(b_arr[k]+"\n");

            }
            }

        System.out.println(count);
        System.out.println(sb);






        }


        }






















