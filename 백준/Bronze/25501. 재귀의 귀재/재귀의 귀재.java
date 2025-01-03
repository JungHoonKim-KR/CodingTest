import java.io.*;

public class Main {
    static int count=1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            bw.write(isPalindrome(br.readLine())+" "+ count+"\n");
            count=1;
        }
        bw.flush();

    }

    static int recursion(String s, int l, int r){
        if(l>=r)
            return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else{
            count++;
            return recursion(s, l+1, r-1);
        }
    }

    static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);

    }
}