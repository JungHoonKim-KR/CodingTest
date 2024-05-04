import java.io.*;

public class Main {
    private static int count=1;
    private static int recursion(String s, int f, int e){
        if(f>=e) return 1;
        else if(s.charAt(f) != s.charAt(e)) return 0;
        else {
            count++;
            return recursion(s,f+1,e-1);
        }
    }
    private static int isPalindrome(String s){
        return recursion(s,0,s.length()-1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        for(int i =0;i<num;i++){
            bw.write(isPalindrome(br.readLine())+" "+count+"\n");
            count=1;
        }
        bw.flush();
        bw.close();
    }
}