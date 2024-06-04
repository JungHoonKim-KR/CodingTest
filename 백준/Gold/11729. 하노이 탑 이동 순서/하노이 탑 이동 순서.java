import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.lang.StringBuilder;




public class Main {
       static StringBuilder sb = new StringBuilder();
        public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

                int n = Integer.parseInt(br.readLine());
                System.out.println((int)Math.pow(2,n)-1);
                pole(n,1,3,2);
                bw.write(sb.toString());
                bw.flush();
                bw.close();


        }

        public static void pole(int n,int x,int y,int z){
                if(n>=1) {
                        pole(n - 1, x, z, y);
                        sb.append(x+" "+y+"\n");
                        pole(n-1,z,y,x);

                }

        }

}