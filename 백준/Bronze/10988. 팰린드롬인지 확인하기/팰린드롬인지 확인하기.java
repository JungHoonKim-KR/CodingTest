import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char [] arr = br.readLine().toCharArray();
        int result = 1;
        for(int i =0; i<arr.length/2; i++){
            if(arr[i] != arr[arr.length-i-1]){
                result = 0;
                break;
            }
        }
        bw.write(result+"");
        bw.flush();
    }
}



