import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());


        if (n == 1) {
            System.out.println(100);
        } else {
            int sum=0;
            int arr[][]=new int[101][101];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x= Integer.parseInt(st.nextToken());
                int y= Integer.parseInt(st.nextToken());

                for(int j=x;j<x+10;j++){
                    for(int k=y;k<y+10;k++){
                        arr[j][k]=1;
                    }
                }

            }
            for(int i=1;i<101;i++){
                for(int j=1;j<101;j++){
                    if(arr[i][j]==1){
                        arr[i][j]=0;
                        sum++;
                    }
                }
            }

            System.out.println(sum);
        }

    }
}