import java.io.*;
import java.util.PriorityQueue;

public class rectangles2 {
    public static void main(String[] args) throws IOException {
        File file1 = new File("rectangles.inp");
        File file2 = new File("rectangles.out");
        FileReader fileReader = new FileReader(file1);
        FileWriter fileWriter = new FileWriter(file2);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int num = Integer.parseInt(bufferedReader.readLine());
        PriorityQueue<Integer> perimeterList = new PriorityQueue<>();
        int a, b;
        int m = 2, n;
        for (; m <= 1000; m++) {
            for (n = 1; n < m; n++) {
                if ((m - n) % 2 == 1 && gcd(m, n) == 1) {
                    a = 2 * m * n;
                    b = m * m - n * n;
                    perimeterList.add(2 * (a + b));
                }
            }
        }
        for (int i = 0; i < num; i++) {
            int sumPerimeter = 0;
            int result = 0;
            int wireLength = Integer.parseInt(bufferedReader.readLine());

            PriorityQueue<Integer> tempList = new PriorityQueue<>(perimeterList);
            while (!tempList.isEmpty()) {
                Integer perimeter = tempList.poll();
                if (sumPerimeter + perimeter > wireLength) break;
                sumPerimeter += perimeter;
                result++;
            }
            fileWriter.write(result + "\n");
        }
        fileWriter.flush();
        fileWriter.close();
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }
}
