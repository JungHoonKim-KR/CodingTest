import java.io.*;
import java.lang.String;
import java.util.*;
import java.util.stream.IntStream;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //문제 받기
        int testcase=Integer.parseInt(br.readLine());
        int count[]=new int [testcase];
        StringTokenizer st;
        for(int i=0;i<testcase;i++){
            st=new StringTokenizer(br.readLine());
            int start_x=Integer.parseInt(st.nextToken());
            int start_y=Integer.parseInt(st.nextToken());
            int end_x=Integer.parseInt(st.nextToken());
            int end_y=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(br.readLine());

            for(int j=0;j<c;j++){
                st=new StringTokenizer(br.readLine());
                int circle_x=Integer.parseInt(st.nextToken());
                int circle_y=Integer.parseInt(st.nextToken());
                int circle_r=Integer.parseInt(st.nextToken());
                //case1 한 점이 원 내부에 있을떄
                if(!(Math.pow(start_x-circle_x,2)+Math.pow(start_y-circle_y,2)<Math.pow(circle_r,2)&&Math.pow(end_x-circle_x,2)+Math.pow(end_y-circle_y,2)<Math.pow(circle_r,2)))
                if(Math.pow(start_x-circle_x,2)+Math.pow(start_y-circle_y,2)<Math.pow(circle_r,2)||Math.pow(end_x-circle_x,2)+Math.pow(end_y-circle_y,2)<Math.pow(circle_r,2))
                    count[i]++;
            }

        }
        for(int z=0;z<testcase;z++){
            System.out.println(count[z]);
        }
   

        }

        
    }





















