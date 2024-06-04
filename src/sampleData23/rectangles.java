import java.io.*;
import java.util.*;

class recPoint implements Comparable<recPoint> {
    int x, startY, endY;
    boolean isStart;


    recPoint(int x, int y1, int y2, boolean isStart) {
        this.x = x;
        this.startY = y1;
        this.endY = y2;
        this.isStart = isStart;
    }

    @Override
    public int compareTo(recPoint o) {
        return Integer.compare(this.x, o.x);
    }
}

public class rectangles {
    private static TreeMap<Integer, Integer> activePoint = new TreeMap<>();
    private static int[] activeP = new int[20001];

    public static void main(String[] args) throws IOException {
        File file1 = new File("rectangles.inp");
        File file2 = new File("rectangles.out");
        FileReader fileReader = new FileReader(file1);
        FileWriter fileWriter = new FileWriter(file2);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int num = Integer.parseInt(bufferedReader.readLine());
        recPoint[] data = new recPoint[num * 2];
        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            data[i * 2] = new recPoint(startX, startY, endY, true);
            data[i * 2 + 1] = new recPoint(endX, startY, endY, false);
        }
        Arrays.sort(data);
        int prevX = data[0].x;
        long totalArea = 0;
        for (recPoint event : data) {
            long lengthY = getLength();
            if (event.isStart) {
                activeP[event.startY + 10000] += 1;
                activeP[event.endY + 10000] -= 1;
            } else {
                activeP[event.startY + 10000] -= 1;
                activeP[event.endY + 10000] += 1;
            }

            totalArea += lengthY * (event.x - prevX);
            prevX = event.x;
        }

        fileWriter.write(totalArea + "\n");
        fileWriter.flush();
        fileWriter.close();

    }

    static long getLength() {
        int state = 0;
        long length = 0;
        int prevY = 0;

        for (int i = -10000; i <= 10000; i++) {
            if (activeP[i + 10000] != 0) {
                if (state > 0) {
                    length += i - prevY;
                }
                state += activeP[i + 10000];
                prevY = i;
            }

        }
        return length;
    }
}

