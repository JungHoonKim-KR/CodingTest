import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer> stationToLines[] = new ArrayList[n+1];
        ArrayList<Integer> lineToStations[] = new ArrayList[m+1];
        boolean visitStations[] = new boolean[n+1];
        boolean visitLines[] = new boolean[m+1];

        for(int i = 1; i <= n; i++){
            stationToLines[i] = new ArrayList<>();
        }
        for(int i = 1; i <= m; i++){
            lineToStations[i] = new ArrayList<>();
        }
        for(int line = 1; line <= m; line++){
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                int station = Integer.parseInt(st.nextToken());
                if(station == -1)
                    break;

                stationToLines[station].add(line);
                lineToStations[line].add(station);
            }
        }

        st = new StringTokenizer(br.readLine());
        int startStation = Integer.parseInt(st.nextToken());
        int endStation = Integer.parseInt(st.nextToken());

        if(startStation == endStation){
            System.out.println(0);
            return;
        }

        Queue<int[]>q = new LinkedList<>();

        for(int line : stationToLines[startStation]){
            q.add(new int[]{line,0});
            visitLines[line] = true;

        }

        visitStations[startStation] = true;
        while(!q.isEmpty()) {
            int cur[] = q.poll();
            for (int station : lineToStations[cur[0]]) {
                if (station == endStation) {
                    System.out.println(cur[1]);
                    return;
                }

                if (!visitStations[station]) {
                    visitStations[station] = true;
                    for (int line : stationToLines[station]) {
                        if (!visitLines[line]) {
                            q.add(new int[]{line, cur[1] + 1});
                            visitLines[line] = true;
                        }
                    }
                }
            }
        }
        // 불가능한 경우
        System.out.println(-1);


    }
}