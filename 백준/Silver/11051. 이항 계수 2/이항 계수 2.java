import java.io.*;
import java.lang.String;
import java.util.*;



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //문제 받기
        StringTokenizer st=new StringTokenizer(br.readLine());
        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());
        int arr[][]=new int [a+1][a+1];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<=i;j++){
                if(i==j||j==0){
                    arr[i][j]=1;
                }
                else arr[i][j]=(arr[i-1][j-1]+arr[i-1][j])%10007;
            }
        }
        System.out.println(arr[a][b]);

        }


        }


























