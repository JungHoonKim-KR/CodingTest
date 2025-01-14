import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c =Integer.parseInt(st.nextToken());

        long points[] = new long [n];

        long max = 0;
        for(int i =0; i<n; i++){
            long tree = Long.parseLong(br.readLine());
            max = Math.max(max, tree);
            points[i] = tree;
        }

        // 우선 정렬이 필요함
        Arrays.sort(points);

        // 집 좌표를 이용해서 각 집 사이의 거리를 구함.
        long distances[] = new long [n-1];

        for(int i = 1; i<n; i++){
            distances[i-1] = points[i] - points[i-1];
        }

        long min = 0;
        max ++;
        while(min < max){
            long mid = (min + max)/2;
            // 카운팅이 중요함
            // 주어진 distances[]를 순서대로 조합해가며 mid가 넘지 않는 선에서 최대한 조합.
            // 조합된 거리를 count 1로 보고, count == C를 만족해야함.
            long section=0;
            int count = 1;
            for(long distance : distances){
                if(section + distance <=mid){
                    section += distance;
                }
                else {
                    section = 0;
                    count++;
                }

            }

            // 해당 간격에서 설치될 수 있는 공유기가 적다면
            // 간격을 좁혀야함.
            if(count < c){
                max = mid;
            }
            else min = mid +1;
        }

        System.out.println(min);
    }





}