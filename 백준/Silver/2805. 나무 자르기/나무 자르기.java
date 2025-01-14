import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long trees[] = new long [n];

        long max = 0;
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++){
            long tree = Long.parseLong(st.nextToken());
            max = Math.max(max, tree);
            trees[i] = tree;
        }

        long min = 0;

        // mid의 길이가 나무를 자룰 H의 길이임. 그럼 나무는 tree - H 만큼의 길이를 만듦.
        // Tree-H의 합이 h를 만족하는지
        // H가 최대가 되어야 하니 UpperBound
        max ++;
        while(min < max){
            long mid = (min + max) /2;
            long length = 0;
            for(long tree : trees){
                if(tree - mid > 0)
                    length += tree - mid;
            }
            // 자른 길이의 합이 목표 보다 작다 == H를 줄여야 함
            if(length < m){
                max = mid;
            }
            else min = mid+1;
        }

        // min max가 엇갈렸을 때 min은 최적의 H의 오른쪽에 위치함(UpperBound)
        System.out.println(min -1);


    }





}