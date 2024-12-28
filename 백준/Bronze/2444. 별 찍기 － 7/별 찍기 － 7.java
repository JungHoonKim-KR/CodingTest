import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringBuilder[] sbArr = new StringBuilder[2*n-1];
        for(int i=1; i<=n;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<n-i;j++){
                sb.append(" ");
            }
            for(int j=0;j<2*i-1;j++){
                sb.append("*");
            }
            sb.append("\n");
            sbArr[i-1] = sb;
        }

        for(int i=0;i<n-1;i++){
            sbArr[i+n] = new StringBuilder(sbArr[n-2-i].toString());
        }
        for(int i =0; i<2*n-1;i++){
            bw.write(sbArr[i].toString());
        }
        bw.flush();
    }
}



