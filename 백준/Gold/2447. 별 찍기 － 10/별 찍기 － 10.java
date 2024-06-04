import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;




public class Main {
    static String arr[][];



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n=Integer.parseInt(br.readLine());

        arr=new String[n][n];
        star(0,0,n,true);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
               sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }


    public static void star(int a, int b, int n, boolean isstar) {
        int count=0;
        if(n==1) {
            if (isstar)
                arr[a][b] = "*";
            else
                arr[a][b] = " ";
            return;
        }
        for(int i=a;i<a+n;i+=n/3){
            for(int j=b;j<b+n;j+=n/3){
                if(++count!=5 && isstar)
                    star(i,j,n/3,true);
                else
                    star(i,j,n/3,false);

            }
        }


    }

}

