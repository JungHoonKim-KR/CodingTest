import java.io.*;
import java.lang.String;
import java.util.*;



public class Main {
    static int Max=Integer.MIN_VALUE;
    static int Min=Integer.MAX_VALUE;
    static int arr[];
    static int oper[];
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //문제 받기
        N=Integer.parseInt(br.readLine());
        arr=new int [N];
        oper=new int[4];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());

        }
        st=new StringTokenizer(br.readLine());
        for(int j=0;j<4;j++){
            oper[j]=Integer.parseInt(st.nextToken());
        }
        dfs(arr[0],1);
        System.out.println(Max);
        System.out.println(Min);


        }

            public static void dfs(int value,int index){
            if(index==N){
                Max=Math.max(value,Max);
                Min=Math.min(value,Min);
                return;
            }
            for(int i=0;i<4;i++) {
                if (oper[i] > 0) {
                    oper[i]--;

                    switch (i) {
                        case 0:
                            dfs(value+arr[index],index+1);
                            break;
                        case 1:
                            dfs(value-arr[index],index+1);
                            break;
                        case 2:
                            dfs(value*arr[index],index+1);
                            break;
                        case 3:
                            dfs(value/arr[index],index+1);
                            break;
                    }
                   oper[i]++;
                }


            }
        }

    }


































