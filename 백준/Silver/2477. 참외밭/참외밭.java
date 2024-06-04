import java.io.*;
import java.lang.String;
import java.util.*;
import java.util.stream.IntStream;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max_x=0;
        int max_y=0;
        int x=0;
        int y=0;
        int n=Integer.parseInt(br.readLine());
        int arr[][]=new int[6][2];
            StringTokenizer st;
            for(int i=0;i<6;i++){
                st=new StringTokenizer(br.readLine());
                arr[i][0]=Integer.parseInt(st.nextToken());
                arr[i][1]=Integer.parseInt(st.nextToken());


            }

            for(int j=0;j<6;j++){
                if(arr[j][0]==1 || arr[j][0]==2){
                    if(max_x<arr[j][1]) {
                        max_x = arr[j][1];
                        if(j==5){
                            y = (int) (Math.abs(arr[4][1] - arr[0][1]));
                        }
                        else if(j==0){
                            y = (int) (Math.abs(arr[5][1] - arr[1][1]));
                        }

                        else {
                            y = (int) (Math.abs(arr[j - 1][1] - arr[j + 1][1]));
                        }
                    }
                }

            }
            for(int k=0;k<6;k++){
                if(arr[k][0]==3 || arr[k][0]==4){
                    if(max_y<arr[k][1]) {
                        max_y = arr[k][1];
                        if(k==5){
                            x = (int) (Math.abs(arr[4][1] - arr[0][1]));
                        }
                        else if(k==0){
                            x = (int) (Math.abs(arr[5][1] - arr[1][1]));
                        }
                        else {
                            x = (int) (Math.abs(arr[k - 1][1] - arr[k + 1][1]));
                        }
                    }
                }

            }
            int area=(max_x*max_y)-(x*y);
        System.out.println(area*n);

    }
}





















