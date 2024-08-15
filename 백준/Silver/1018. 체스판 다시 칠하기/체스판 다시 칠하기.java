import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;




public class Main {

    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];
        int min = n * m;
        for (int y = 0; y < n; y++) {
            String input = br.readLine();
            for (int x = 0; x < m; x++) {
                arr[y][x] = input.charAt(x);
            }
        }
        for (int w = 0; w < n - 7; w++) {
            for (int s = 0; s < m - 7; s++) {
                min = Math.min(min, cal(w, s));
            }
        }

        System.out.println(min);
    }

    public static int cal(int x, int y) {

        int count = 0;

        for (int j = x; j < x + 8; j++) {
            for (int z = y; z < y + 8; z++) {
                if ((x + y) % 2 == (j + z) % 2) {

                    if (arr[j][z] != arr[x][y])
                        count++;

                } else if ((x + y) % 2 != (j + z) % 2) {
                    if (arr[j][z] == arr[x][y])
                        count++;


                }


            }
        }

        return Math.min(count,64-count);

    }
}

