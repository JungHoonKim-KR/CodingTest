import java.util.*;
import java.io.*;

 class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
            int n = Integer.parseInt(br.readLine());

            for(int j=1; j<=n; j++){
                String s= Integer.toString(j);
                StringBuilder result = new StringBuilder();
                if(judge(s)){
                    for(int k=0; k<s.length(); k++){
                        if(judge(String.valueOf(s.charAt(k)))){
                            result.append("-");
                        }
                    }
                }
                else
                    result.append(s);

                result.append(" ");
                sb.append(result);
            }

        System.out.println(sb);

    }
    static boolean judge(String s){
        if(s.contains("3") || s.contains("6") || s.contains("9"))
            return true;
        return false;
    }


}