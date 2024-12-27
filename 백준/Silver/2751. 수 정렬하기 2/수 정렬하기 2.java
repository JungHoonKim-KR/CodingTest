import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

       int n = Integer.parseInt(br.readLine());
       int arr[] = new int[n];
       for(int i =0; i<n; i++){
           arr[i] = Integer.parseInt(br.readLine());
       }
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Collections.sort(list);
        list.stream().forEach(i -> {
            try {
                bw.write(i+"\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        bw.flush();
    }
}


