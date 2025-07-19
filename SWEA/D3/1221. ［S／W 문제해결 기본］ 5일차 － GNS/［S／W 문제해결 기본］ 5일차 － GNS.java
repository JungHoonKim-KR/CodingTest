import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testcase = Integer.parseInt(br.readLine());

        Map<String, Integer> strToInt = new HashMap<>();
        strToInt.put("ZRO", 0);
        strToInt.put("ONE", 1);
        strToInt.put("TWO", 2);
        strToInt.put("THR", 3);
        strToInt.put("FOR", 4);
        strToInt.put("FIV", 5);
        strToInt.put("SIX", 6);
        strToInt.put("SVN", 7);
        strToInt.put("EGT", 8);
        strToInt.put("NIN", 9);

        Map<Integer, String> intToStr = new HashMap<>();
        intToStr.put(0, "ZRO");
        intToStr.put(1, "ONE");
        intToStr.put(2, "TWO");
        intToStr.put(3, "THR");
        intToStr.put(4, "FOR");
        intToStr.put(5, "FIV");
        intToStr.put(6, "SIX");
        intToStr.put(7, "SVN"); // 원본 코드에 'SNV'로 오타가 있어 'SVN'으로 수정했습니다.
        intToStr.put(8, "EGT");
        intToStr.put(9, "NIN");

        for (int tc = 1; tc <= testcase; tc++) {
            int n = Integer.parseInt(br.readLine().split(" ")[1]);
            bw.write("#" + tc + "\n");

            int arr[] = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = strToInt.get(st.nextToken());
            }
            Arrays.sort(arr);
            for(int value : arr){
                bw.write(intToStr.get(value)+" ");
            }
            bw.write("\n");

        }
        bw.flush();

    }


}