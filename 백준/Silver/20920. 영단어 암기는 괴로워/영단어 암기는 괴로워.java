import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int std = Integer.parseInt(st.nextToken());
        Map<String,Integer> data = new HashMap<>();
        for(int i = 0 ;i<num ; i++){
            String s = br.readLine();
            if(s.length()>=std)
                data.put(s,data.getOrDefault(s,0)+1);
        }
        Comparator<Map.Entry<String,Integer>> frequency = Map.Entry.comparingByValue(Comparator.reverseOrder());
        Comparator<Map.Entry<String,Integer>> length = Map.Entry.comparingByKey(Comparator.comparingInt(String::length).reversed());
        Comparator<Map.Entry<String,Integer>> alphabet = Map.Entry.comparingByKey();

        Comparator<Map.Entry<String,Integer>> combined = frequency.thenComparing(length).thenComparing(alphabet);
        List<Map.Entry<String,Integer>> transformedData = new ArrayList<>(data.entrySet());

        Collections.sort(transformedData,combined);
        for(Map.Entry<String,Integer> entry: transformedData ){
            bw.write(entry.getKey()+"\n");
        }
        bw.flush();
        bw.close();
    }
}