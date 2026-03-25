import java.io.*;
import java.util.*;

/*
    4방 탐색
    지점 값이 -1 or 1이면 진행 X
 */
public class Main {
    static char[] arr;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = br.readLine().toCharArray();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'X') {
                count++;
            } else {
                if(!func(count)){
                    System.out.println(-1);
                    return;
                }
                count = 0;
                bw.write(".");
            }
        }

        // count는 남아 있음
        if(!func(count)){
            System.out.println(-1);
            return;
        }

        bw.flush();

    }

    static boolean func(int count) throws IOException {
        if (count % 2 == 1) {
            return false;
        }

        for (int i = 0; i < count / 4; i++) {
            bw.write("AAAA");
        }

        if (count % 4 == 2) {
            bw.write("BB");
        }
        return true;
    }


}

