import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        LinkedHashMap<Integer, List<String>> map = new LinkedHashMap<>();
        for(int i=0; i<n; i++){
            st  = new StringTokenizer(br.readLine());
            map.computeIfAbsent(Integer.parseInt(st.nextToken()),k->new ArrayList<>()).add(st.nextToken());
        }
        LinkedHashMap<Integer, List<String>> collect = map.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new
                ));

        for(Map.Entry<Integer,List<String>> entry : collect.entrySet()){
            for(String value:entry.getValue()){
                    bw.write(entry.getKey()+" "+ value+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
}