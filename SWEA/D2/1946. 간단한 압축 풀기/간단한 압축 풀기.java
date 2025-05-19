import java.util.*;
import java.io.*;

 class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int testcase = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= testcase; tc++) {
            result.append("#" + tc+"\n");
            int n = Integer.parseInt(br.readLine());

            String s[] = new String[n];
            int count[] = new int[n];
            for(int i  = 0; i < n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                s[i] = st.nextToken();
                count[i] = Integer.parseInt(st.nextToken());
            }

            ArrayList<String> list = new ArrayList();

            for(int i = 0; i<n; i++){
                while(count[i] > 0){
                    list.add(s[i]);
                    count[i]--;
                }
            }
            int c=0;
            for(int i = 0; i<list.size(); i++){
                result.append(list.get(i));
                c++;

                if(c == 10){
                    c=0;
                    result.append("\n");
                }
            }

            result.append("\n");

        }
        System.out.println(result);
    }

}










