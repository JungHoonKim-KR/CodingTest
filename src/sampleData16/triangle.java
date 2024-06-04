import java.io.*;
import java.util.StringTokenizer;

class TP {
    int x, y;

    TP(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class triangle {
    public static void main(String[] args) throws IOException {
        File file1 = new File("triangle.inp");
        File file2 = new File("triangle.out");
        FileReader fileReader = new FileReader(file1);
        FileWriter fileWriter = new FileWriter(file2);
        BufferedReader bufferedReader = new BufferedReader(fileReader);


        int num = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < num; i++) {
            TP arr[] = new TP[3];
            double lengthArr[] = new double[3];
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < 3; j++) {
                TP tp = new TP(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                arr[j] = tp;
            }

            for (int j = 1; j <= 3; j++) {
                double length = (Math.pow((arr[j % 3].x - arr[j - 1].x), 2) + Math.pow((arr[j % 3].y - arr[j - 1].y), 2));
                lengthArr[j - 1] = length;
            }
            if (lengthArr[0 ]+ lengthArr[1]  == lengthArr[2] ||  lengthArr[0] + lengthArr[2]  ==  lengthArr[1] || lengthArr[2]  + lengthArr[1]  == lengthArr[0])
                fileWriter.write("1\n");
            else if ( lengthArr[0] + lengthArr[1] <  lengthArr[2]||  lengthArr[0] + lengthArr[2]  <  lengthArr[1] ||lengthArr[2] +lengthArr[1] <  lengthArr[0])
                fileWriter.write("2\n");
            else fileWriter.write("0\n");
        }
        fileWriter.flush();
        fileWriter.close();
    }
}
