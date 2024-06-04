import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class cycle {
    public static void main(String[] args) throws IOException {
        File file1 = new File("cycle.inp");
        File file2 = new File("cycle.out");
        FileReader fileReader = new FileReader(file1);
        FileWriter fileWriter = new FileWriter(file2);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringTokenizer st;

        String line;
        int num = Integer.parseInt(bufferedReader.readLine());
        int data[];
        for (int i = 0; i < num; i++) {
            int size = Integer.parseInt(bufferedReader.readLine());
            data = new int[size+1];
            ArrayList<ArrayList<Integer>> cycleList = new ArrayList<>();
            ArrayList<Integer> visited = new ArrayList<>();
            line = bufferedReader.readLine();
            st = new StringTokenizer(line);
            for (int j = 1; j <= size; j++) {
                data[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j <= size; j++) {
                if(!visited.contains(j)){
                    ArrayList<Integer> cycle = new ArrayList<>();
                    int cur = j;

                    while(!visited.contains(cur)){
                        visited.add(cur);
                        cycle.add(cur);
                        cur = data[cur];
                    }
                    if(cycle.get(0) == cur){
                        cycleList.add(cycle);
                    }
                }
            }
            fileWriter.write(cycleList.size()+"\n");

        }
        fileWriter.flush();
        fileWriter.close();
    }
}