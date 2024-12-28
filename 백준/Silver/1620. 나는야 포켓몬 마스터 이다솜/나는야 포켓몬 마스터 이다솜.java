import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st =new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> nameMap = new HashMap<>();
        HashMap<Integer, String> numMap = new HashMap<>();
        for(int i =1; i<=n; i++){
            String name = br.readLine();
            nameMap.put(name,i);
            numMap.put(i,name);
        }

        for(int i=1; i<=m; i++){
            String s = br.readLine();
            if(s.chars().allMatch(Character::isDigit)){
                bw.write(numMap.get(Integer.parseInt(s))+"\n");
            }
            else bw.write(nameMap.get(s)+"\n");
        }
        bw.flush();
        bw.close();
    }



}