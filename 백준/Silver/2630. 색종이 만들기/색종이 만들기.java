import java.io.*;
import java.util.*;

public class Main {
    static int blue = 0;
    static int white = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        char arr[][] = new char[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j =0; j < n; j++) {
                arr[i][j] = st.nextToken().charAt(0);
            }
        }
        square(arr, 0, 0, n);

        bw.write(white+"\n" + blue);
        bw.flush();
        br.close();
        bw.close();
    }

    static void square(char arr[][], int startY, int startX, int term) {

        if (term == 1) {
            if (arr[startY][startX] == '0') white++;
            else blue++;
            return;
        }
        char color;
        if( (color = check(arr, startY, startX, term)) == 'x') {
            square(arr, startY, startX, term / 2);
            square(arr, startY + term / 2, startX, term / 2);
            square(arr, startY, startX + term / 2, term / 2);
            square(arr, startY + term / 2, startX + term / 2, term / 2);
        }

        else if(color == '0') white++;
        else blue++;


    }

    static char check(char arr[][], int startY, int startX, int term) {
        char color  = arr[startY][startX];
        for(int i =startY; i<startY+term; i++) {
            for(int j =startX; j<startX+term; j++) {
                if(color != arr[i][j]) {
                    return 'x';
                }
            }
        }
        return color;
    }
}
